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

    private final Player _player;
    private Timeline _powerIncreaseTimeline;

    // The field is 10 meters
    private final double _widthSpace = 10;

    public GamePresenter(GameController controller) {
        _controller = controller;
        _transformationSpace = new TransformationSpace(controller.getWidth(), controller.getHeight(), _widthSpace);

        Target target = new CircleTarget(new Point(5, 1, 5), 10, 1);
        Weapon bow = new Bow(new Point(5, 1.5));
        Shooter shooter = new Shooter(target, bow, 500);
        _player = new Human(shooter);

        TargetView targetView = controller.createTargetView();
        WeaponView weaponView = controller.createWeaponView();
        ShooterView shooterView = controller.createShooterView();

        _targetPresenter = new TargetPresenter(this, _transformationSpace, target, targetView);
        _weaponPresenter = new WeaponPresenter(this, _transformationSpace, bow, weaponView);
        _shooterPresenter = new ShooterPresenter(_transformationSpace, shooter, shooterView);
        updateView();
    }

    public void handleMousePressed() {
        // Charge Bow
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(50), f -> {
            _weaponPresenter.increasePower();
            _weaponPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(Animation.INDEFINITE);
        _powerIncreaseTimeline.play();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        _player.play();
        _weaponPresenter.updateView();
        ProjectilePresenter projectilePresenter = _weaponPresenter.createProjectilePresenter(this);
        new Thread(() -> {
            while (!projectilePresenter.hasReachedDestination()) {
                projectilePresenter.updateView();
                sleep(50);
            }
            updateView();
        }).start();
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
