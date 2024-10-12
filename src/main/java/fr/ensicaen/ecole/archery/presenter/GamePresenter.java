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

    private final TargetPresenter _targetPresenter;
    private final WeaponPresenter _weaponPresenter;
    private final ShooterPresenter _shooterPresenter;

    private final Player _player;
    private Timeline _powerIncreaseTimeline;

    public GamePresenter(GameController controller) {
        double x = controller.getWidth() / 2;
        double y = 150;
        Target target = new CircleTarget(new Point(x, y, 15), 10, 150);
        Weapon bow = new Bow(new Point(200, 40));
        Shooter shooter = new Shooter(target, bow, 500);
        _player = new Human(shooter);

        TargetView targetView = controller.createTargetView();
        WeaponView weaponView = controller.createWeaponView();
        ShooterView shooterView = controller.createShooterView();

        _targetPresenter = new TargetPresenter(target, targetView);
        _weaponPresenter = new WeaponPresenter(bow, weaponView);
        _shooterPresenter = new ShooterPresenter(shooter, shooterView);
        updateView();
    }

    public void handleMousePressed() {
        // Charge Bow
        _powerIncreaseTimeline = new Timeline(new KeyFrame(Duration.millis(50), _ -> {
            _weaponPresenter.increasePower();
            _weaponPresenter.updateView();
        }));
        _powerIncreaseTimeline.setCycleCount(Animation.INDEFINITE);
        _powerIncreaseTimeline.play();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        _player.play();
        _weaponPresenter.reset();
        updateView();
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

}
