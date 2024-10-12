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
    private ImageView BowView;
    private Pane root;

    public WeaponView(Pane root) {
        Image bowImage = new Image("bow.png");
    }

    private WeaponPresenter _weaponPresenter;



    public void setPresenter(WeaponPresenter weaponPresenter) {
        _weaponPresenter = weaponPresenter;
    }

    public void draw(Point position, double angleX, double angleY) {

    }

}
