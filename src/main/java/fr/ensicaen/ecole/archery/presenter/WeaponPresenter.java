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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class WeaponPresenter {

    private static final double POWER_INCREMENT = 10;
    private final Weapon _weapon;
    private final WeaponView _weaponView;
    private double _mouseX;
    private double _mouseY;

    public WeaponPresenter (Weapon weapon, WeaponView weaponView){
        _weapon = weapon;
        _weaponView = weaponView;
    }

    public void setMouseX(double mouseX) {
        _mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        _mouseY = mouseY;
    }

    public void increasePower() {
        _weapon.increasePower(POWER_INCREMENT);
    }

    public void reset() {
        _weapon.setPower(0);
    }

    public void updateView() {
        updateViewPower();
        double x = _weaponView.getArea().getPrefWidth() / 2 - 50 ;
        double y = _weaponView.getArea().getPrefHeight() - 150;
        // System.out.println(_mouseX);
         double distx = x - _mouseX;
         double disty = y - _mouseY;
         double rotationAngle = Math.atan2(disty , distx);
        _weaponView.drawBow(new Point(x, y), rotationAngle );
    }

    private void updateViewPower() {
        double height = _weapon.getPower() * _weaponView.getPowerArea().getPrefHeight() / _weapon.getMaxPower();
        double y = _weaponView.getPowerArea().getPrefHeight() - height;
        _weaponView.drawPower(0, y, _weaponView.getPowerArea().getPrefWidth(), height);
    }

}
