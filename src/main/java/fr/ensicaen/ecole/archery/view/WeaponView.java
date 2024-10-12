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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import fr.ensicaen.ecole.archery.presenter.WeaponPresenter;


public class WeaponView {
    private final ImageView _BowView;
    private final AnchorPane _area;
    private WeaponPresenter _weaponPresenter;
    public WeaponView(AnchorPane area) {
        Image bowImage = new Image("fr/ensicaen/ecole/archery/bow.png");
        _BowView = new ImageView(bowImage);
        _BowView.setFitWidth(100);
        _BowView.setFitHeight(200);
        _area = area;
        _area.getChildren().add(_BowView);
    }




    public void setPresenter(WeaponPresenter weaponPresenter) {
        _weaponPresenter = weaponPresenter;
    }

    public void draw(Point position, double rotationAngle) {
        _BowView.setX(position.x);
        _BowView.setY(position.y);
        _BowView.setRotate(rotationAngle);

    }

}
