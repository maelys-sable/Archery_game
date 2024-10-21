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
import fr.ensicaen.ecole.archery.view.controller.GameController;
import fr.ensicaen.ecole.archery.view.controller.MainTitleController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTitlePresenter {
    MainTitleController _controller;

    public MainTitlePresenter(MainTitleController controller) {
        _controller = controller;
    }

    public void createGameWindow(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Game.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);

        primaryStage.setTitle("Archery");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        GameController gameController = loader.getController();
        scene.addEventHandler(MouseEvent.MOUSE_RELEASED, gameController::onMouseReleased);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, gameController::onMousePressed);
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, gameController::onMouseMoved);
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, gameController::onMouseMoved);

<<<<<<< HEAD
    public void createGame(IGameController gameController, int numberOfArrows, int targetDistance) {
        BuilderDomain builderDomain = new BuilderDomain();
        builderDomain.buildNumberOfArrow(numberOfArrows);
        builderDomain.buildTargetDistance(targetDistance);
        gameController.setBuilderDomain(builderDomain);
        gameController.launchGamePresenter();
=======
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

}