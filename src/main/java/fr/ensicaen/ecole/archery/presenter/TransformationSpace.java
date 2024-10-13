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
        //        double distanceProjectionX = 128;
        //        double distanceProjectionY = 100;
        //        double renderX = modelPosition.x * distanceProjectionX  + _widthScreen / 2;
        //        double renderY = _heightScreen - modelPosition.y * distanceProjectionY;
        double renderY;
        double extendY = modelPosition.z / 20;
        double extendX = modelPosition.z / 2 ;
        double zeroForY = _heightScreen - _heightScreen / (2 + modelPosition.z / 100);
        double maxX = 10 + extendX * 2;
        double maxY = 5 + extendY;
        double renderX = modelPosition.x * _widthScreen / maxX + _widthScreen / 2;
        if (modelPosition.z == 0.1 ) {
            renderY = modelPosition.y + 4 * _heightScreen / 5;
        } else {
            renderY =  _heightScreen - modelPosition.y * _heightScreen / maxY - zeroForY;
        }
            return new Point(renderX, renderY);
    }

    public double transformRadius(Point modelPosition, double radius) {
        return (radius * 25 / modelPosition.z);
    }

}
