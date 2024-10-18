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


import fr.ensicaen.ecole.archery.presenter.IGameController;
import fr.ensicaen.ecole.archery.presenter.BuilderDomain;
import fr.ensicaen.ecole.archery.presenter.GamePresenter;
import fr.ensicaen.ecole.archery.view.component.ProjectileView;
import fr.ensicaen.ecole.archery.view.component.ShooterView;
import fr.ensicaen.ecole.archery.view.component.TargetView;
import fr.ensicaen.ecole.archery.view.component.BowView;
import fr.ensicaen.ecole.archery.view.component.bow.DefaultBowView;
import fr.ensicaen.ecole.archery.view.component.bow.ProfessionalBowView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

/**
 * The FXML Controller of the game
 * It is the connection point of all graphical game components of FXML
 * It also have the role of a mini factory to create View with graphical components
 */
public class GameController implements IGameController {

    @FXML
    private AnchorPane _mainArea;

    @FXML
    private Pane _powerArea;

    @FXML
    private Label _arrowLabel;

    @FXML
    private Label _scoreLabel;

    private GamePresenter _gamePresenter;

    private BuilderDomain _builderDomain;

    private Screen _screen;
    @FXML
    private ComboBox<String> chooseBow;
    @FXML
    public void initialize() {
        chooseBow.getItems().addAll("Arc Débutant", "Arc Profesionnel");
        chooseBow.setValue("Arc Débutant");
        chooseBow.setOnAction(event -> {
            _gamePresenter.changeBow(chooseBow.getSelectionModel().getSelectedItem());

        });
    }

    public void launchGamePresenter() {
        _gamePresenter = new GamePresenter(this);
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return;
        }
        _gamePresenter.handleMousePressed();
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != MouseButton.PRIMARY) {
            return;
        }
        _gamePresenter.handleMouseReleased();
    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        _gamePresenter.handleMouseMoved(mouseEvent.getX(), mouseEvent.getY());
    }

    public void onResetClicked() {
        _gamePresenter.resetPlayer();
    }

    public void onMenu() {
        _screen.switchScene();
    }

    public void setBuilderDomain(BuilderDomain builderDomain) {
        _builderDomain = builderDomain;
    }

    public void setScreen(Screen screen) {
        _screen = screen;
    }

    public TargetView createTargetView() {
        return new TargetView(_mainArea);
    }

    @Override
    public BuilderDomain getModelDomain() {
        return _builderDomain;
    }

    public BowView createBowView(String bowTypeString) {
        switch (bowTypeString) {
            case "Arc Profesionnel":
                return new ProfessionalBowView(_mainArea, _powerArea);
            default:
                return new DefaultBowView(_mainArea,_powerArea);
        }
    }

    public ShooterView createShooterView() {
        return new ShooterView(_arrowLabel, _scoreLabel);
    }

    public ProjectileView createProjectileView() {
        return new ProjectileView(_mainArea);
    }

    public double getWidth() {
        return _mainArea.getPrefWidth();
    }

    public double getHeight() {
        return _mainArea.getPrefHeight();
    }

}
