package fr.ensicaen.ecole.archery.model.space;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

public class TransformationSpace {

    private final double _widthScreen;
    private final double _heightScreen;
    private final double _widthSpace;
    private final double _heightSpace;
    private final double _zCam = 1;

    public TransformationSpace(double widthScreen, double heightScreen, double widthSpace) {
        _widthScreen = widthScreen;
        _heightScreen = heightScreen;
        _widthSpace = widthSpace;
        _heightSpace = heightScreen * widthSpace / _widthScreen;
    }

    public double getWidthScreen() {
        return _widthScreen;
    }

    public double getHeightScreen() {
        return _heightScreen;
    }

    public Point transformModelPositionToViewPosition(Point modelPosition) {
        double renderX = _widthSpace / 2 + _zCam * (modelPosition.x - _widthSpace / 2) / modelPosition.z;
        double renderY = _heightSpace / 2 - _zCam * (modelPosition.y - _heightSpace / 2) / modelPosition.z;
        renderX *= getScaleFieldToScreenRatio();
        renderY *= getScaleFieldToScreenRatio();
        return new Point(renderX, renderY);
    }

    public double transformRadius(Point modelPosition, double radius) {
        return (radius / modelPosition.z * _zCam) * getScaleFieldToScreenRatio();
    }

    private double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
    }

}
