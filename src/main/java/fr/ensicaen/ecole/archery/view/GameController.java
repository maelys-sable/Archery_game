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
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class GameController {

    @FXML
    private Pane _targetArea;

    @FXML
    private AnchorPane _mainArea;

    @FXML
    private Pane _powerArea;

    @FXML
    private Label _arrowLabel;

    @FXML
    private Label _scoreLabel;

    private GamePresenter _gamePresenter;

    @FXML
    public void initialize() {
        _gamePresenter = new GamePresenter(this);
    }

    public double getWidth() {
        return _mainArea.getPrefWidth();
    }

    public double getHeight() {
        return _mainArea.getPrefHeight();
    }

    public TargetView createTargetView() {
        return new TargetView(_mainArea, _targetArea);
    }

    public WeaponView createWeaponView() {
        return new WeaponView(_mainArea, _powerArea);
    }

    public ShooterView createShooterView() {
        return new ShooterView(_arrowLabel, _scoreLabel);
    }

    public ProjectileView createProjectileView() {
        return new ProjectileView(_mainArea);
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        _gamePresenter.handleMousePressed();
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        _gamePresenter.handleMouseReleased();
    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        _gamePresenter.handleMouseMoved(mouseEvent.getX(), mouseEvent.getY());
    }

}
