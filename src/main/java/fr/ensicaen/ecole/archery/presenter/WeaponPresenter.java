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

import fr.ensicaen.ecole.archery.model.Point;
import fr.ensicaen.ecole.archery.view.WeaponView;
import fr.ensicaen.ecole.archery.model.Weapon;
import javafx.scene.layout.Pane;

public class WeaponPresenter implements Presenter {

    private final Weapon _weapon;
    private final WeaponView _weaponView;
    private final Pane _Area;
    public WeaponPresenter (Weapon weapon, WeaponView weaponView, Pane Area){
        _weapon = weapon;
        _weaponView = weaponView;
        _Area =  Area;
    }


    @Override
    public void updateModel() {
    }

    @Override
    public void drawView() {
        double x = _Area.getPrefWidth() / 2 - 50 ;
        double y = _Area.getPrefHeight() - 150;
        _weaponView.draw(new Point(x, y) );
    }

}
