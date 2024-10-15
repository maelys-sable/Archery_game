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

import fr.ensicaen.ecole.archery.Main;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.space.ModelDomain;
import fr.ensicaen.ecole.archery.model.space.TransformationSpace;
import fr.ensicaen.ecole.archery.view.*;
import fr.ensicaen.ecole.archery.view.bow.BowView;
import fr.ensicaen.ecole.archery.view.controller.GameController;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

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
    }

    public void handleMousePressed() {
        chargeBow();
    }

    public void handleMouseReleased() {
        _powerIncreaseTimeline.stop();
        Projectile projectile = _modelDomain.getPlayer().play();
        _bowPresenter.updateView();
        setAnimationProjectile(projectile);

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
        ProjectilePresenter projectilePresenter = new ProjectilePresenter(_transformationSpace, projectile, _controller.createProjectileView());
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
    public void createMenuWindow(Stage primaryStage) throws IOException {
        System.out.println("BONJOUR");

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainTitle.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);

        primaryStage.setTitle("Archery");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}
