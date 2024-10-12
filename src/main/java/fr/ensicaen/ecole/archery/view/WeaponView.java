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
import javafx.scene.layout.Pane;

import fr.ensicaen.ecole.archery.presenter.WeaponPresenter;


public class WeaponView {
    private final ImageView _BowView;
    private final Pane _area;
    private WeaponPresenter _weaponPresenter;
    public WeaponView(Pane area) {
        Image bowImage = new Image("fr/ensicaen/ecole/archery/bow.png");
        _BowView = new ImageView(bowImage);

        _area = area;
    }




    public void setPresenter(WeaponPresenter weaponPresenter) {
        _weaponPresenter = weaponPresenter;
    }

    public void draw(Point position, double angleX, double angleY) {
        _BowView.setX(position.x);
        _BowView.setY(position.y);

        double rotationAngle = Math.toDegrees(Math.atan2(angleY, angleX));
        _BowView.setRotate(rotationAngle);
        _area.getChildren().add(_BowView);
    }

}
