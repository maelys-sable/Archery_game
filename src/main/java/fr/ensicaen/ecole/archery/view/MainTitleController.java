package fr.ensicaen.ecole.archery.view;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.presenter.GamePresenter;
import fr.ensicaen.ecole.archery.presenter.MainTitlePresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTitleController {

    @FXML
    private AnchorPane _mainArea;

    @FXML
    private Button _playButton;

    private MainTitlePresenter _mainTitlePresenter;
    private Stage _primaryStage;

    @FXML
    public void initialize() {
        _mainTitlePresenter = new MainTitlePresenter(this);
    }

    public void createGameWindow(ActionEvent e) throws IOException {
        _mainTitlePresenter.createGameWindow(_primaryStage);
    }

    public void setPrimaryStage(Stage primaryStage) {
        _primaryStage = primaryStage;
    }
}