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

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.space.TransformationSpace;
import fr.ensicaen.ecole.archery.view.bow.BowView;

public class BowPresenter {


    private Bow _bow;
    private BowView _bowView;
    private double _mouseX;
    private double _mouseY;
    private final TransformationSpace _transformationSpace;

    public BowPresenter(TransformationSpace transformationSpace, Bow weapon, BowView bowView){
        _bow = weapon;
        _bowView = bowView;
        _transformationSpace = transformationSpace;
    }

    public void changeBow(Shooter shooter, Bow newBow, BowView newBowView) {
        _bowView = newBowView;
        _bow = newBow;
        shooter.setBow(newBow);
    }

    public void setMouseX(double mouseX) {
        _mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        _mouseY = mouseY;
    }

    public void increasePower() {
        _bow.increasePower();
    }

    public void updateView() {
        updateViewPower();
        Point position = _transformationSpace.transformModelPositionToViewPosition(_bow.getPosition());
        position.x -= _bowView.getWidth() / 2;
        position.y -= _bowView.getHeight() / 2;

        Point angles = _transformationSpace.computeAngleFromAPosition(position, new Point(_mouseX, _mouseY));
        double angleX = angles.x;
        double angleY = angles.y;

        _bow.setAngleY(angleY);
        _bow.setAngleX(angleX);

        int index = (int) (_bowView.getNbImages() * (_bow.getPower() - 0.1) /_bow.getMaxPower());
        position.y -= 40;
        _bowView.drawBow(position, Math.toDegrees(angles.z), index);
    }



    private void updateViewPower() {
        double height = _bow.getPower() * _bowView.getPowerArea().getPrefHeight() / _bow.getMaxPower();
        double y = _bowView.getPowerArea().getPrefHeight() - height;
        _bowView.drawPower(0, y, _bowView.getPowerArea().getPrefWidth(), height);
    }

}
