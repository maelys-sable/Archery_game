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

import fr.ensicaen.ecole.archery.view.Screen;
import fr.ensicaen.ecole.archery.presenter.MainTitlePresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MainTitleController {

    @FXML
    public Slider _numberOfArrowsSlider;

    @FXML
    public Label _numberSelected;

    private MainTitlePresenter _mainTitlePresenter;

    private Screen _screen;

    @FXML
    public void initialize() {
        _mainTitlePresenter = new MainTitlePresenter();
        _numberOfArrowsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            _numberSelected.setText(newValue.intValue() + "");
        });
    }

    public void createGame(ActionEvent e) {
        _screen.switchScene();
        _mainTitlePresenter.createGame(_screen.getGameController(), (int) _numberOfArrowsSlider.getValue());
    }

    public void setScreen(Screen screen) {
        _screen = screen;
    }

}
