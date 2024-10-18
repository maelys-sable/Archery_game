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

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.Domain;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.presenter.component.*;
import fr.ensicaen.ecole.archery.view.component.BowView;
import fr.ensicaen.ecole.archery.view.component.ShooterView;
import fr.ensicaen.ecole.archery.view.component.TargetView;
import fr.ensicaen.ecole.archery.view.GameController;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * The master mind of all presenter
 * This is the main presenter, it manages all interaction and split task to correct presenters
 */
public class GamePresenter {

    private final IGameController _controller;
    private final BowPresenter _bowPresenter;
    private final ShooterPresenter _shooterPresenter;
    private final AdapterTransformationSpace _adapterTransformationSpace;
    private final TargetPresenter _targetPresenter;
    private final int _animationTime = 50;
    private final int _maxNumberCycle = 100;
    private final Domain _domain;
    private Timeline _powerIncreaseTimeline;
    private Timeline _trajectoryTimeline;

    public GamePresenter(GameController controller) {
        _controller = controller;
        _domain = controller.getModelDomain().build();
        _adapterTransformationSpace = new AdapterTransformationSpace(
                controller.getWidth(), controller.getHeight(), _domain.widthSpace
        );

        TargetView targetView = controller.createTargetView();

        ShooterView shooterView = controller.createShooterView();

        _targetPresenter = new TargetPresenter(_adapterTransformationSpace, _domain.target, targetView);
        BowView weaponView = controller.createBowView("");
        _bowPresenter = new BowPresenter(_adapterTransformationSpace, _domain.defaultBow, weaponView);
        _shooterPresenter = new ShooterPresenter(_domain.shooter, shooterView);
        updateView();
    }

    public void handleMousePressed() {
        chargeBow();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        Projectile projectile = _domain.player.play();
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

    public void resetPlayer() {
        _shooterPresenter.resetShooter();
    }

    public void changeBow(String bowTypeString) {
        Bow bow = getSelectedBowFromComboBox(bowTypeString);
        BowView bowView = _controller.createBowView(bowTypeString);
        _bowPresenter.killView();
        _bowPresenter.changeBow(_domain.shooter, bow, bowView);
        _bowPresenter.updateView();
    }

    private Bow getSelectedBowFromComboBox(String bowTypeString) {
        switch(bowTypeString) {
            case "Arc Profesionnel" :
                return _domain.professionalBow;
            default:
                return _domain.defaultBow;
        }
    }

    private void setAnimationProjectile(Projectile projectile) {
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(_adapterTransformationSpace, projectile, _controller.createProjectileView());
        _trajectoryTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            projectilePresenter.updateView();
            if (projectileIsBehindTarget(projectile, projectilePresenter.getDepth()) && projectilePresenter.getDepth() > _targetPresenter.getTargetPosition().z) {
                projectilePresenter.killInstant();
                _trajectoryTimeline.stop();

                updateView();
            }
            if (projectilePresenter.hasReachedDestination()) {
                updateView();
                projectilePresenter.kill();
                _trajectoryTimeline.stop();
            }
        }));
        _trajectoryTimeline.setCycleCount(_maxNumberCycle);
        _trajectoryTimeline.play();
    }

    private boolean projectileIsBehindTarget(Projectile projectile, double depth) {
        Point targetPositionOnScreen = _adapterTransformationSpace.project3DPointTo2D(_targetPresenter.getTargetPosition());
        Point projectilePositionOnScreen = _adapterTransformationSpace.project3DPointTo2D(projectile.computePositionFromDistance(depth));
        double distanceBetweenTargetAndProjectile = distanceBetweenTwoPoints(targetPositionOnScreen,projectilePositionOnScreen);
        double targetRadiusOnScreen = _adapterTransformationSpace.transformRadius(_targetPresenter.getTargetPosition(),_targetPresenter.getTargetRadius());
        return distanceBetweenTargetAndProjectile < targetRadiusOnScreen;
    }
    private double distanceBetweenTwoPoints(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private void chargeBow() {
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            _bowPresenter.increasePower();
            _bowPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(_maxNumberCycle);
        _powerIncreaseTimeline.play();
    }

    private void updateView() {
        _bowPresenter.updateView();
        _shooterPresenter.updateView();
    }

}
