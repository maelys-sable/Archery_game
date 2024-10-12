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

import fr.ensicaen.ecole.archery.model.Point;
import fr.ensicaen.ecole.archery.presenter.WeaponPresenter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class WeaponView {

    private WeaponPresenter _weaponPresenter;
    private Pane _powerArea;
    private AnchorPane _area;

    public WeaponView(AnchorPane area, Pane powerArea) {
        _area = area;
        _powerArea = powerArea;
    }

    public void setPresenter(WeaponPresenter weaponPresenter) {
        _weaponPresenter = weaponPresenter;
    }

    public void draw(Point position, double angleX, double angleY) {

    }

    public void drawPower() {
        Rectangle rectangle = new Rectangle();
        rectangle.se
        _area.getChildren().add(rectangle);
    }

}
