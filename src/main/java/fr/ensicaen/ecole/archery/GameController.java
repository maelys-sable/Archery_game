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

import fr.ensicaen.ecole.archery.model.*;
import fr.ensicaen.ecole.archery.presenter.*;
import fr.ensicaen.ecole.archery.view.ShooterView;
import fr.ensicaen.ecole.archery.view.TargetView;
import fr.ensicaen.ecole.archery.view.WeaponView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {

    @FXML
    private Pane _targetArea;

    @FXML
    private AnchorPane _mainArea;

    private Player _player;
    private Presenter _targetPresenter;
    private Presenter _weaponPresenter;
    private Presenter _shooterPresenter;
    private List<Presenter> _presenters = new ArrayList<>();

    @FXML
    public void initialize() {
        double x = _targetArea.getLayoutX() + _targetArea.getPrefWidth() / 2;
        double y = 150;

        Target target = new CircleTarget(new Point(x, y, 1), 10, 150);
        Weapon bow = new Bow(new Point(200, 40));

        Shooter shooter = new Shooter(
                target, bow, 500
        );

        _player = new Human(shooter);

        TargetView targetView = new TargetView(_mainArea);
        WeaponView weaponView = new WeaponView();
        ShooterView shooterView = new ShooterView();

        _targetPresenter = new TargetPresenter(target, targetView, _targetArea);
        _weaponPresenter = new WeaponPresenter(bow, weaponView);
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

    public void onMouseClicked(MouseEvent mouseEvent) {
        _player.play();
        drawView();
    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        if (_weaponPresenter != null) {
            _weaponPresenter.updateModel();
            _weaponPresenter.drawView();
        }

    }

    public void onMouseScrolled(ScrollEvent scrollEvent) {
        System.out.println(scrollEvent.getDeltaX());
    }

}
