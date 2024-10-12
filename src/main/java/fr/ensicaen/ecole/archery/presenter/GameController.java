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

import fr.ensicaen.ecole.archery.model.*;

import fr.ensicaen.ecole.archery.view.ShooterView;
import fr.ensicaen.ecole.archery.view.TargetView;
import fr.ensicaen.ecole.archery.view.WeaponView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private Player _player;
    private TargetPresenter _targetPresenter;
    private WeaponPresenter _weaponPresenter;
    private ShooterPresenter _shooterPresenter;
    private final List<Presenter> _presenters = new ArrayList<>();
    private boolean _isMousePressed = false;

    @FXML
    public void initialize() {
        double x = _targetArea.getLayoutX() + _targetArea.getPrefWidth() / 2;
        double y = 150;
        Target target = new CircleTarget(new Point(x, y, 15), 10, 150);
        Weapon bow = new Bow(new Point(200, 40));
        Shooter shooter = new Shooter(
                target, bow, 500
        );
        _player = new Human(shooter);
        TargetView targetView = new TargetView(_mainArea);
        WeaponView weaponView = new WeaponView(_mainArea, _powerArea);
        ShooterView shooterView = new ShooterView(_arrowLabel, _scoreLabel);
        _targetPresenter = new TargetPresenter(target, targetView, _targetArea);
        _weaponPresenter = new WeaponPresenter(bow, weaponView, _mainArea, _powerArea);
        _shooterPresenter = new ShooterPresenter(shooter, shooterView);
        addPresenter(_targetPresenter, _weaponPresenter, _shooterPresenter);
        drawView();
    }

    private void addPresenter(Presenter... presenters) {
        _presenters.addAll(Arrays.asList(presenters));
    }

    public void drawView() {
        for (Presenter presenter: _presenters) {
            presenter.drawView();
        }
    }

    public void onMousePressed(MouseEvent mouseEvent) {
        _isMousePressed = true;
        /* Charge the Bow */
        new Thread(() -> {
            while (_isMousePressed) {
                _weaponPresenter.increasePower();
                _weaponPresenter.drawView();
                sleep(50);
            }
        }).start();
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        _isMousePressed = false;
        _weaponPresenter.reset();
        _player.play();
        drawView();
    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        _weaponPresenter.setMouseX(mouseEvent.getX());
        _weaponPresenter.setMouseY(mouseEvent.getY());
        _weaponPresenter.updateModel();
        _weaponPresenter.drawView();
    }

    public void sleep(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException ignored) { }
    }

}
