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

import fr.ensicaen.ecole.archery.MainTitle;
import fr.ensicaen.ecole.archery.model.*;
import fr.ensicaen.ecole.archery.view.*;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainTitlePresenter {
    MainTitleController _controller;

    public MainTitlePresenter(MainTitleController controller) {
        _controller = controller;
    }

    public void createGameWindow(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainTitle.class.getResource("Game.fxml"));
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

    }

}