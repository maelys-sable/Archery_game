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
import fr.ensicaen.ecole.archery.view.bow.BowView;

/**
 * Class for mediation between the view of the bow and the object
 */
public class BowPresenter {

    private final AdapterTransformationSpace _adapterTransformationSpace;
    private Bow _bow;
    private BowView _bowView;
    private double _mouseX;
    private double _mouseY;

    public BowPresenter(AdapterTransformationSpace adapterTransformationSpace, Bow weapon, BowView bowView){
        _bow = weapon;
        _bowView = bowView;
        _adapterTransformationSpace = adapterTransformationSpace;
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
        final double adjustYPosition = 40;
        Point bowPosition = _adapterTransformationSpace.project3DPointTo2D(_bow.getPosition());
        bowPosition.x -= _bowView.getWidth() / 2;
        bowPosition.y -= _bowView.getHeight() / 2;
        Point angles = _adapterTransformationSpace.computeAngleXAndAngleYFromAPosition(
                bowPosition, new Point(_mouseX, _mouseY)
        );
        _bow.setAngleY(angles.y);
        _bow.setAngleX(angles.x);
        /* _bow.getPower() - 0.1 to ignore case index = nbImage */
        int index = (int) (_bowView.getNbImages() * (_bow.getPower() - 0.1) /_bow.getMaxPower());
        bowPosition.y -= adjustYPosition;
        _bowView.drawBow(bowPosition, Math.toDegrees(angles.z), index);
    }

    private void updateViewPower() {
        double height = _bow.getPower() * _bowView.getPowerArea().getPrefHeight() / _bow.getMaxPower();
        double y = _bowView.getPowerArea().getPrefHeight() - height;
        double x = 0;
        _bowView.drawPower(x, y, _bowView.getPowerArea().getPrefWidth(), height);
    }

}
