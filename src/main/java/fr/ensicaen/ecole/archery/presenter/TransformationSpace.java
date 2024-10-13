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

public class TransformationSpace {

    private final double _widthScreen;
    private final double _heightScreen;
    private final double _widthSpace;
    private static final double FOV = Math.PI / 3;

    public TransformationSpace(double widthScreen, double heightScreen, double widthSpace) {
        _widthScreen = widthScreen;
        _heightScreen = heightScreen;
        _widthSpace = widthSpace;
    }

    public double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
    }

    public Point transformModelPositionToViewPosition(Point modelPosition) {
        double distanceProjectionX = 128;
        double distanceProjectionY = 100;
        double renderX = modelPosition.x * distanceProjectionX  + _widthScreen / 2;
        double renderY = _heightScreen - modelPosition.y * distanceProjectionY;
        return new Point(renderX, renderY);
    }

    public double transformRadius(Point modelPosition, double radius) {
        return (radius / modelPosition.z * 1) * getScaleFieldToScreenRatio();
    }

}
