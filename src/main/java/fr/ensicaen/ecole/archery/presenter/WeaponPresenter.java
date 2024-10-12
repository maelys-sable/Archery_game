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

public class WeaponPresenter implements Presenter {

    private final Weapon _weapon;
    private final WeaponView _weaponView;

    public WeaponPresenter (Weapon weapon, WeaponView weaponView){
        _weapon = weapon;
        _weaponView = weaponView;
    }


    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {

        _weaponView.draw(new Point(50,50), 0, 0);
    }

}
