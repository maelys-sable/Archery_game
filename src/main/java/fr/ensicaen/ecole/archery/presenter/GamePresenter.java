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
import fr.ensicaen.ecole.archery.model.bow.BowFactory;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.Domain;
import fr.ensicaen.ecole.archery.view.*;
import fr.ensicaen.ecole.archery.view.bow.BowView;
import fr.ensicaen.ecole.archery.view.controller.GameController;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * The master mind of all presenter
 * This is the main presenter, it manages all interaction and split task to correct presenters
 */
public class GamePresenter {

    private final GameController _controller;
    private final BowPresenter _bowPresenter;
    private final ShooterPresenter _shooterPresenter;
    private final AdapterTransformationSpace _adapterTransformationSpace;

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

        BowFactory.BowType bowType = BowFactory.BowType.DEFAULT_BOW;

        BowView weaponView = controller.createBowView(bowType);
        ShooterView shooterView = controller.createShooterView();
        /* Target presenter doesn't need to be stocked */
        new TargetPresenter(_adapterTransformationSpace, _domain.target, targetView);
        _bowPresenter = new BowPresenter(_adapterTransformationSpace, _domain.defaultBow, weaponView);
        _shooterPresenter = new ShooterPresenter(_domain.shooter, shooterView);
        updateView();
    }

    public synchronized void handleMousePressed() {
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

    private void updateView() {
        _bowPresenter.updateView();
        _shooterPresenter.updateView();
    }

    public void resetPlayer() {
        _shooterPresenter.resetShooter();
    }

    private void chargeBow() {
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            _bowPresenter.increasePower();
            _bowPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(_maxNumberCycle);
        _powerIncreaseTimeline.play();
    }
public void changeBow(String item) {
        Bow bow = getSelectedBowFromComboBox(item);
        BowFactory.BowType bowType = getSelectedBowTypeFromComboBox(item);
        Shooter shooter = _domain.shooter;
        BowView bowView = _controller.createBowView(bowType);
        _bowPresenter.killView();
        _bowPresenter.changeBow(shooter, bow, bowView);
        _bowPresenter.updateView();

}
    public Bow getSelectedBowFromComboBox(String item) {
        switch(item) {
            case "Arc Profesionnel" :
                return _domain.professionalBow;
            default:
                return _domain.defaultBow;
        }
    }
    public BowFactory.BowType getSelectedBowTypeFromComboBox(String item) {
        switch(item) {
            case "Arc Profesionnel" :
                return BowFactory.BowType.PROFESSIONAL_BOW;
            default:
                return BowFactory.BowType.DEFAULT_BOW;
        }
    }

    private void setAnimationProjectile(Projectile projectile) {
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(_adapterTransformationSpace, projectile, _controller.createProjectileView());
        _trajectoryTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            projectilePresenter.updateView();
            if (projectilePresenter.hasReachedDestination()) {
                updateView();
                projectilePresenter.kill();
                _trajectoryTimeline.stop();
            }
        }));
        _trajectoryTimeline.setCycleCount(_maxNumberCycle);
        _trajectoryTimeline.play();
    }


}
