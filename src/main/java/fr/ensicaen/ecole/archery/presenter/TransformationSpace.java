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

    public TransformationSpace(double widthScreen, double heightScreen, double widthSpace) {
        _widthScreen = widthScreen;
        _heightScreen = heightScreen;
        _widthSpace = widthSpace;
    }

    public Point transformModelPositionToViewPosition(Point modelPosition) {
        double scaleFactor = _widthScreen / _widthSpace;
        double renderX = modelPosition.x * scaleFactor;
        double renderY = _heightScreen - modelPosition.y * scaleFactor;
        return new Point(renderX, renderY, modelPosition.z);
    }

    public double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
    }

}
