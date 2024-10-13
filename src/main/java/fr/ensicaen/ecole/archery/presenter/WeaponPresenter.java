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
import fr.ensicaen.ecole.archery.view.ProjectileView;
import fr.ensicaen.ecole.archery.view.WeaponView;
import fr.ensicaen.ecole.archery.model.Weapon;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class WeaponPresenter {

    private static final double POWER_INCREMENT_SCALE = 0.05;
    private final Weapon _weapon;
    private final WeaponView _weaponView;
    private double _mouseX;
    private double _mouseY;
    private final GamePresenter _presenter;
    private final TransformationSpace _transformationSpace;

    public WeaponPresenter (GamePresenter presenter, TransformationSpace transformationSpace, Weapon weapon, WeaponView weaponView){
        _presenter = presenter;
        _weapon = weapon;
        _weaponView = weaponView;
        _transformationSpace = transformationSpace;
    }

    public void setAngleX(double angleX){
        _weapon.setAngleX(angleX);
    }

    public void setAngleY(double angleY){
        _weapon.setAngleY(angleY);
    }

    public void setMouseX(double mouseX) {
        _mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        _mouseY = mouseY;
    }

    public void increasePower() {
        _weapon.increasePower(POWER_INCREMENT_SCALE);
    }

    public void updateView() {
        updateViewPower();
        Point position = _transformationSpace.transformModelPositionToViewPosition(_weapon.getPosition());
        position.x -= 50;
        position.y -= 10;
        double deltax = position.x + 50 - _mouseX;
        double deltay = position.y - _mouseY + 100;
        double rotationAngle = -Math.atan2(deltax , deltay) -Math.PI / 2 ;

        if (rotationAngle > -Math.PI / 6 ) {
            rotationAngle = -Math.PI / 6;
        }
        if (rotationAngle < 5 * -Math.PI / 6 ) {
            rotationAngle = 5 * -Math.PI / 6;
        }

        double angleX = rotationAngle + Math.PI / 2;

        if (angleX > Math.PI / 3 ) {
            angleX = Math.PI / 3;
        }

        if (angleX < -Math.PI / 3 ) {
            angleX =  -Math.PI / 3;
        }
        double angleY = -(_mouseY * Math.PI / (2 * _weaponView.getArea().getPrefHeight()) - Math.PI / 4 )  ;

        setAngleY(angleY);
        setAngleX(angleX);
        _weaponView.drawBow(position, Math.toDegrees(rotationAngle) );
    }

    private void updateViewPower() {
        double height = _weapon.getPower() * _weaponView.getPowerArea().getPrefHeight() / _weapon.getMaxPower();
        double y = _weaponView.getPowerArea().getPrefHeight() - height;
        _weaponView.drawPower(0, y, _weaponView.getPowerArea().getPrefWidth(), height);
    }

}
