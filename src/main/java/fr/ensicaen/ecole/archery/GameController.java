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
import fr.ensicaen.ecole.archery.presenter.TargetPresenter;
import fr.ensicaen.ecole.archery.presenter.WeaponPresenter;
import fr.ensicaen.ecole.archery.view.TargetView;
import fr.ensicaen.ecole.archery.view.WeaponView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class GameController {

    @FXML
    private Pane _targetArea;

    @FXML
    private AnchorPane _mainArea;

    @FXML
    public void initialize() {
        double x = _targetArea.getLayoutX() + _targetArea.getPrefWidth() / 2;
        double y = 150;

        Target target = new CircleTarget(new Point(x, y, 1), 10, 150);

        Shooter shooter = new Shooter(target, new Bow(new Point(200, 40)), 500);

        Weapon weapon = new Bow(new Point(0,0));

        Player player = new Human(shooter);

        TargetView targetView = new TargetView(_mainArea);
        TargetPresenter targetPresenter = new TargetPresenter(target, targetView, _targetArea);
        targetPresenter.drawView();

        WeaponView weaponView = new WeaponView(_mainArea);
        WeaponPresenter weaponPresenter = new WeaponPresenter(weapon, weaponView);
        weaponPresenter.drawView();
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX());
    }

    public void onMouseMoved(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX());
    }

    public void onMouseScrolled(ScrollEvent scrollEvent) {
        System.out.println(scrollEvent.getDeltaX());
    }

}
