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

import fr.ensicaen.ecole.archery.model.bow.BowFactory;
import fr.ensicaen.ecole.archery.Main;
import fr.ensicaen.ecole.archery.model.space.ModelDomain;
import fr.ensicaen.ecole.archery.presenter.GamePresenter;
import fr.ensicaen.ecole.archery.view.ProjectileView;
import fr.ensicaen.ecole.archery.view.ShooterView;
import fr.ensicaen.ecole.archery.view.TargetView;
import fr.ensicaen.ecole.archery.view.bow.BowView;
import fr.ensicaen.ecole.archery.view.bow.DefaultBowView;
import fr.ensicaen.ecole.archery.view.bow.ProfessionalBowView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameController {

    @FXML
    private AnchorPane _mainArea;

    @FXML
    private Pane _powerArea;

    @FXML
    private Label _arrowLabel;

    @FXML
    private Label _scoreLabel;

    private GamePresenter _gamePresenter;

    private Stage _primaryStage = Main.getPrimaryStage();
    private ModelDomain _modelDomain;

    @FXML
    public void initialize() {}

    public void launchGamePresenter() {
        _gamePresenter = new GamePresenter(this);
    }

    public double getWidth() {
        return _mainArea.getPrefWidth();
    }

    public double getHeight() {
        return _mainArea.getPrefHeight();
    }

    public TargetView createTargetView() {
        return new TargetView(_mainArea);
    }

    public BowView createBowView(BowFactory.BowType type) {
        switch (type) {
            case DEFAULT_BOW:
                return new DefaultBowView(_mainArea,_powerArea);
            case PROFESSIONAL_BOW:
                return new ProfessionalBowView(_mainArea, _powerArea);
            default:
                throw new IllegalArgumentException("Unsupported bow type: " + type);
        }
    }

//    public BowView createDefaultBowView() {
//        return new DefaultBowView(_mainArea, _powerArea);
//    }
//
//    public BowView createProfessionalBowView() {
//        return new ProfessionalBowView(_mainArea, _powerArea);
//    }

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
    public void onResetClicked() {
        _gamePresenter.resetView();
    }
    public void onMenu() {

        try {
            _gamePresenter.createMenuWindow(_primaryStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setModelDomain(ModelDomain modelDomain) {
        _modelDomain = modelDomain;
    }

    public ModelDomain getModelDomain() {
        return _modelDomain;
    }
}
