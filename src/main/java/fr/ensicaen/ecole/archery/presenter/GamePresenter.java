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

import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.Domain;
import fr.ensicaen.ecole.archery.view.*;
import fr.ensicaen.ecole.archery.view.bow.BowView;
import fr.ensicaen.ecole.archery.view.controller.GameController;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class GamePresenter {

    private final GameController _controller;
    private final BowPresenter _bowPresenter;
    private final ShooterPresenter _shooterPresenter;
    private final AdapterTransformationSpace _adapterTransformationSpace;

    private final Domain _domain;
    private Timeline _powerIncreaseTimeline;
    private Timeline _trajectoryTimeline;

    public GamePresenter(GameController controller) {
        _controller = controller;
        _domain = controller.getModelDomain().build();
        _adapterTransformationSpace = new AdapterTransformationSpace(
                controller.getWidth(), controller.getHeight(), _domain.getWidthSpace()
        );
        TargetView targetView = controller.createTargetView();
        BowView weaponView = controller.createDefaultBowView();
        ShooterView shooterView = controller.createShooterView();
        new TargetPresenter(_adapterTransformationSpace, _domain.getTarget(), targetView);
        _bowPresenter = new BowPresenter(_adapterTransformationSpace, _domain.getBow(), weaponView);
        _shooterPresenter = new ShooterPresenter(_domain.getShooter(), shooterView);
        updateView();
    }

    public void handleMousePressed() {
        chargeBow();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        Projectile projectile = _domain.getPlayer().play();
        _bowPresenter.updateView();
        if (projectile != null) {
            setAnimationProjectile(projectile);
        }
    }

    public void handleMouseMoved(double x, double y) {
        _bowPresenter.setMouseX(x);
        _bowPresenter.setMouseY(y);
        _bowPresenter.updateView();
    }

    private void updateView() {
        _bowPresenter.updateView();
        _shooterPresenter.updateView();
    }
    public void resetView() {
        _shooterPresenter.resetView();
    }

    private void chargeBow() {
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            _bowPresenter.increasePower();
            _bowPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(Animation.INDEFINITE);
        _powerIncreaseTimeline.play();
    }

    private void setAnimationProjectile(Projectile projectile) {
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(_adapterTransformationSpace, projectile, _controller.createProjectileView());
        _trajectoryTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            projectilePresenter.updateView();
            if (projectilePresenter.hasReachedDestination()) {
                updateView();
                projectilePresenter.kill();
                _trajectoryTimeline.stop();
            }
        }));
        _trajectoryTimeline.setCycleCount(Animation.INDEFINITE);
        _trajectoryTimeline.play();
    }


}
