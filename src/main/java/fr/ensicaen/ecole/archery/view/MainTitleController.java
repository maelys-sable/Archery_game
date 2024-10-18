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

import fr.ensicaen.ecole.archery.presenter.MainTitlePresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * The FXML Controller of the main title
 * It is the connection point of all graphical main title components of FXML
 */
public class MainTitleController {

    @FXML
    private Slider _numberOfArrowsSlider;

    @FXML
    private Slider _targetDistanceSlider;

    @FXML
    private Label _numberSelected;

    @FXML
    private Label _targetNumberSelected;

    private MainTitlePresenter _mainTitlePresenter;

    private Screen _screen;

    @FXML
    public void initialize() {
        _mainTitlePresenter = new MainTitlePresenter();
        _numberOfArrowsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            _numberSelected.setText(newValue.intValue() + "");
        });
        _targetDistanceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            _targetNumberSelected.setText(newValue.intValue() + "");
        });
    }

    public void createGame(ActionEvent e) {
        _screen.switchScene();
        _mainTitlePresenter.createGame(
                _screen.getGameController(),
                (int) _numberOfArrowsSlider.getValue(),
                (int) _targetDistanceSlider.getValue()
        );
    }

    public void setScreen(Screen screen) {
        _screen = screen;
    }

}
