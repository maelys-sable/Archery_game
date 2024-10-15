package fr.ensicaen.ecole.archery.view.controller;

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
import fr.ensicaen.ecole.archery.presenter.MainTitlePresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTitleController {

    @FXML
    public TextField _numberOfArrows;

    @FXML
    public Label _errorMessage;

    @FXML
    private AnchorPane _mainArea;

    @FXML
    private Button _playButton;

    private MainTitlePresenter _mainTitlePresenter;
    private Stage _primaryStage = Main.getPrimaryStage();

    @FXML
    public void initialize() {
        _mainTitlePresenter = new MainTitlePresenter(this);
    }

    public void createGameWindow(ActionEvent e) throws IOException {
        _mainTitlePresenter.createGameWindow(_primaryStage, _numberOfArrows);
    }

    public void setPrimaryStage(Stage primaryStage) {
        _primaryStage = primaryStage;
    }

    public void displayError(String message) {
        _errorMessage.setText(message);
    }
}