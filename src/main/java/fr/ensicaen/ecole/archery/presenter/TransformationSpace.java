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
    private final double _heightSpace;
    private static final double FOV = Math.PI / 3;

    public TransformationSpace(double widthScreen, double heightScreen, double widthSpace) {
        _widthScreen = widthScreen;
        _heightScreen = heightScreen;
        _widthSpace = widthSpace;
        _heightSpace = heightScreen * widthSpace / _widthScreen;
    }

    public double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
    }

    public double fy() {
        return _heightScreen / (2 * Math.tan(FOV / 2));
    }

    public double fx() {
        return _widthScreen / (2 * Math.tan(FOV / 2));
    }

    public Point transformModelPositionToViewPosition(Point modelPosition) {
        double renderX = _widthSpace / 2 + 1 * (modelPosition.x - _widthSpace / 2) / modelPosition.z;
        double renderY = _heightSpace / 2 - 1 * (modelPosition.y - _heightSpace / 2) / modelPosition.z;
        renderX *= getScaleFieldToScreenRatio();
        renderY *= getScaleFieldToScreenRatio();
        return new Point(renderX, renderY);
    }

    public double transformRadius(Point modelPosition, double radius) {
        return (radius / modelPosition.z * 1) * getScaleFieldToScreenRatio();
    }

}
