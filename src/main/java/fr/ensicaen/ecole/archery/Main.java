package fr.ensicaen.ecole.archery;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Game.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);

        primaryStage.setTitle("Archery");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        GameController gameController = loader.getController();
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, gameController::onMouseClicked);
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, gameController::onMouseMoved);
        scene.addEventFilter(ScrollEvent.SCROLL, gameController::onMouseScrolled);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
