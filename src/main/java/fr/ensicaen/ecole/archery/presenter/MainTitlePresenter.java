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
import fr.ensicaen.ecole.archery.model.space.ModelDomain;
import fr.ensicaen.ecole.archery.view.controller.GameController;
import fr.ensicaen.ecole.archery.view.controller.MainTitleController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTitlePresenter {
    MainTitleController _controller;
    private int _numberOfArrows = 6;

    public MainTitlePresenter(MainTitleController controller) {
        _controller = controller;
    }

    public void createGameWindow(Stage primaryStage, TextField textFieldNumberOfArrows) throws IOException {
        /* Initialiser le nombre de flèches */
        _numberOfArrows = parseTextField(textFieldNumberOfArrows);
        if (_numberOfArrows <= 0) {
            _controller.displayError("Veuillez rentrer un nombre entier de flèche supérieur à 0");
            return;
        }
        ModelDomain model = new ModelDomain();
        model.setNumberOfArrow(_numberOfArrows);
        /* Changement de fenêtre */
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Game.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);

        primaryStage.setTitle("Archery");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        GameController gameController = loader.getController();
        gameController.setModelDomain(model);
        gameController.launchGamePresenter();
        scene.addEventHandler(MouseEvent.MOUSE_RELEASED, gameController::onMouseReleased);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, gameController::onMousePressed);
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, gameController::onMouseMoved);
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, gameController::onMouseMoved);
    }

    private int parseTextField(TextField textField) {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}