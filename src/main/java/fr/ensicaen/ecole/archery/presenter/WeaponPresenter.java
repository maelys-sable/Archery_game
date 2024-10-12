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

public class WeaponPresenter implements Presenter {

    private final Weapon _weapon;
    private final WeaponView _weaponView;
    private final AnchorPane _Area;
    private final Pane _powerArea;
    private double _mouseX;
    private double _mouseY;

    public WeaponPresenter (Weapon weapon, WeaponView weaponView, AnchorPane Area, Pane powerArea){
        _weapon = weapon;
        _weaponView = weaponView;
        _Area =  Area;
        _powerArea = powerArea;
    }

    public void setMouseX(double mouseX) {
        _mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        _mouseY = mouseY;
    }

    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {
        drawPower();
        double x = _Area.getPrefWidth() / 2 - 50 ;
        double y = _Area.getPrefHeight() - 150;
        // System.out.println(_mouseX);
         double distx = x - _mouseX;
         double disty = y - _mouseY;
         double rotationAngle = Math.atan2(disty , distx);
        _weaponView.draw(new Point(x, y), rotationAngle );
    }

    private void drawPower() {
        double height = _weapon.getPower() * _powerArea.getPrefHeight() / _weapon.getMaxPower();
        double y = _powerArea.getPrefHeight() - height;
        _weaponView.drawPower(0, y, _powerArea.getPrefWidth(), height);
    }

    public void increasePower() {
        _weapon.increasePower(10);
    }

    public void reset() {
        _weapon.setPower(0);
    }

}
