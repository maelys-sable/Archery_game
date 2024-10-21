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
import fr.ensicaen.ecole.archery.model.space.ModelDomain;
import fr.ensicaen.ecole.archery.model.space.TransformationSpace;
import fr.ensicaen.ecole.archery.view.*;
import fr.ensicaen.ecole.archery.view.bow.BowView;
import fr.ensicaen.ecole.archery.view.controller.GameController;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class GamePresenter {

    private final GameController _controller;
    private final BowPresenter _bowPresenter;
    private final ShooterPresenter _shooterPresenter;
    private final TransformationSpace _transformationSpace;

    private final ModelDomain _modelDomain = new ModelDomain();;
    private Timeline _powerIncreaseTimeline;
    private Timeline _trajectoryTimeline;

    public GamePresenter(GameController controller) {
        _controller = controller;
<<<<<<< HEAD
        _domain = controller.getBuilderDomain().build();
        _adapterTransformationSpace = new AdapterTransformationSpace(
                controller.getWidth(), controller.getHeight(), _domain.widthSpace
        );

        TargetView targetView = controller.createTargetView();
        ShooterView shooterView = controller.createShooterView();
        _targetPresenter = new TargetPresenter(_adapterTransformationSpace, _domain.target, targetView);

        BowView weaponView = controller.createBowView("");
        _bowPresenter = new BowPresenter(_adapterTransformationSpace, _domain.defaultBow, weaponView);
        _shooterPresenter = new ShooterPresenter(_domain.shooter, shooterView);
        _shooterPresenter.updateView();
=======
        _transformationSpace = new TransformationSpace(
                controller.getWidth(), controller.getHeight(), _modelDomain.getWidthSpace()
        );

        TargetView targetView = controller.createTargetView();
        BowView weaponView = controller.createDefaultBowView();
        ShooterView shooterView = controller.createShooterView();

        new TargetPresenter(_transformationSpace, _modelDomain.getTarget(), targetView);
        _bowPresenter = new BowPresenter(_transformationSpace, _modelDomain.getBow(), weaponView);
        _shooterPresenter = new ShooterPresenter(_modelDomain.getShooter(), shooterView);
        updateView();
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

    public void handleMousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return;
        }
        chargeBow();
    }

    public void handleMouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return;
        }
        _powerIncreaseTimeline.stop();
<<<<<<< HEAD
        Projectile projectile = _domain.player.play();
        if (projectile != null) {
            setAnimationProjectile(projectile);
        }
=======
        Projectile projectile = _modelDomain.getPlayer().play();
        _bowPresenter.updateView();
        setAnimationProjectile(projectile);

>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

    public void handleMouseMoved(MouseEvent mouseEvent) {
        _bowPresenter.setMouseX(mouseEvent.getX());
        _bowPresenter.setMouseY(mouseEvent.getY());
    }

<<<<<<< HEAD
    public void resetPlayer() {
        _shooterPresenter.resetShooter();
    }

    public void changeBow(String bowTypeString) {
        Bow bow = getSelectedBowFromComboBox(bowTypeString);
        BowView bowView = _controller.createBowView(bowTypeString);
        _bowPresenter.killView();
        _bowPresenter.changeBow(_domain.shooter, bow, bowView);
    }

    private Bow getSelectedBowFromComboBox(String bowTypeString) {
        if (bowTypeString.equals("Arc Profesionnel")) {
            return _domain.professionalBow;
        }
        return _domain.defaultBow;
=======
    private void updateView() {
        _bowPresenter.updateView();
        _shooterPresenter.updateView();
    }

    private void chargeBow() {
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            _bowPresenter.increasePower();
            _bowPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(Animation.INDEFINITE);
        _powerIncreaseTimeline.play();
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

    private void setAnimationProjectile(Projectile projectile) {
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(_transformationSpace, projectile, _controller.createProjectileView());
        _trajectoryTimeline = new Timeline(new KeyFrame(Duration.millis(50), i -> {
            projectilePresenter.updateView();
<<<<<<< HEAD
            if (projectileIsBehindTarget(projectile, projectilePresenter.getDepth()) && projectilePresenter.getDepth() > _targetPresenter.getTargetPosition().z) {
                projectilePresenter.killInstant();
                _trajectoryTimeline.stop();
                _shooterPresenter.updateView();
            }
=======
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
            if (projectilePresenter.hasReachedDestination()) {
                _shooterPresenter.updateView();
                projectilePresenter.kill();
                _trajectoryTimeline.stop();
            }
        }));
        _trajectoryTimeline.setCycleCount(Animation.INDEFINITE);
        _trajectoryTimeline.play();
    }

<<<<<<< HEAD
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
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> _bowPresenter.increasePower()));
        _powerIncreaseTimeline.setCycleCount(_maxNumberCycle);
        _powerIncreaseTimeline.play();
    }

=======
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
}
