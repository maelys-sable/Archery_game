package fr.ensicaen.ecole.archery.presenter;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.*;
import fr.ensicaen.ecole.archery.view.*;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class GamePresenter {

    private final GameController _controller;
    private final TargetPresenter _targetPresenter;
    private final WeaponPresenter _weaponPresenter;
    private final ShooterPresenter _shooterPresenter;
    private final TransformationSpace _transformationSpace;

    private final ModelDomain _modelDomain;
    private Timeline _powerIncreaseTimeline;
    private Timeline _trajectoryTimeline;

    // The field is 10 meters
    private final double _widthSpace = 3;

    public GamePresenter(GameController controller) {
        _controller = controller;
        _transformationSpace = new TransformationSpace(
                controller.getWidth(), controller.getHeight(), _widthSpace
        );

        _modelDomain = new ModelDomain();
        TargetView targetView = controller.createTargetView();
        WeaponView weaponView = controller.createWeaponView();
        ShooterView shooterView = controller.createShooterView();

        _targetPresenter = new TargetPresenter(this, _transformationSpace, _modelDomain.getTarget(), targetView);
        _weaponPresenter = new WeaponPresenter(this, _transformationSpace, _modelDomain.getWeapon(), weaponView);
        _shooterPresenter = new ShooterPresenter(_transformationSpace, _modelDomain.getShooter(), shooterView);
        updateView();
    }

    public void handleMousePressed() {
        // Charge Bow
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            _weaponPresenter.increasePower();
            _weaponPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(Animation.INDEFINITE);
        _powerIncreaseTimeline.play();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        Projectile projectile = _modelDomain.getPlayer().play();
        _weaponPresenter.updateView();
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(this, _transformationSpace, projectile, _controller.createProjectileView());

        _trajectoryTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            projectilePresenter.updateView();
            if (projectilePresenter.hasReachedDestination()) {
                updateView();
                _trajectoryTimeline.stop();
            }
        }));

        _trajectoryTimeline.setCycleCount(Animation.INDEFINITE);
        _trajectoryTimeline.play();

    }

    public void handleMouseMoved(double x, double y) {
        _weaponPresenter.setMouseX(x);
        _weaponPresenter.setMouseY(y);
        _weaponPresenter.updateView();
    }

    private void updateView() {
        _targetPresenter.updateView();
        _weaponPresenter.updateView();
        _shooterPresenter.updateView();
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {}
    }

}
