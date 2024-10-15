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

import fr.ensicaen.ecole.archery.view.controller.GameController;
import fr.ensicaen.ecole.archery.view.controller.MainTitleController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen {

    private final Stage _primaryStage;
    private final Screen _screen;
    private Scene _scene;
    private GameController _gameController;
    private StateScreen _state = new InMenuState();

    @FunctionalInterface
    private interface StateScreen {
        void switchScene() throws IOException;
    }

    private class InMenuState implements StateScreen {
        @Override
        public void switchScene() throws IOException {
            FXMLLoader fxmlGame = new FXMLLoader(Main.class.getResource("Game.fxml"));
            _scene = new Scene(fxmlGame.load(), 1280, 720);
            _primaryStage.setScene(_scene);
            _gameController = fxmlGame.getController();
            _gameController.setScreen(_screen);
            addEventGame();
            _state = new InGameState();
        }
    }

    private class InGameState implements StateScreen {
        @Override
        public void switchScene() throws IOException {
            FXMLLoader fxmlMainTitle = new FXMLLoader(Main.class.getResource("MainTitle.fxml"));
            _scene = new Scene(fxmlMainTitle.load(), 1280, 720);
            _primaryStage.setScene(_scene);
            MainTitleController _mainTitleController = fxmlMainTitle.getController();
            _mainTitleController.setScreen(_screen);
            _state = new InMenuState();
        }
    }

    public Screen(Stage primaryStage) {
        _primaryStage = primaryStage;
        _screen = this;
    }

    public void run() throws IOException {
        new InGameState().switchScene();
        _primaryStage.setTitle("Archery");
        _primaryStage.setScene(_scene);
        _primaryStage.setResizable(false);
        _primaryStage.show();
    }

    private void addEventGame() {
        _scene.addEventHandler(MouseEvent.MOUSE_RELEASED, _gameController::onMouseReleased);
        _scene.addEventHandler(MouseEvent.MOUSE_PRESSED, _gameController::onMousePressed);
        _scene.addEventFilter(MouseEvent.MOUSE_MOVED, _gameController::onMouseMoved);
        _scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, _gameController::onMouseMoved);
    }

    public void switchScene() {
        try {
            _state.switchScene();
        } catch (IOException ignored) {}
    }

    public Scene getScene() {
        return _scene;
    }

    public GameController getGameController() {
        return _gameController;
    }

}
