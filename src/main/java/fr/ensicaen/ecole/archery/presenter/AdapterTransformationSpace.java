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

import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.space.TransformationSpace;

public class AdapterTransformationSpace {

    private final double _widthScreen;
    private final TransformationSpace _transformationSpace;

    public AdapterTransformationSpace(double widthScreen, double heightScreen, double widthSpace) {
        _widthScreen = widthScreen;
        _transformationSpace = new TransformationSpace(
                widthSpace, heightScreen * widthSpace / widthScreen
        );
    }

    public Point project3DPointTo2D(Point point) {
        Point projectedPoint = _transformationSpace.project3DPointTo2D(point);
        projectedPoint.x *= getScaleFieldToScreenRatio();
        projectedPoint.y *= getScaleFieldToScreenRatio();
        return projectedPoint;
    }

    public double transformRadius(Point point, double radius) {
        return _transformationSpace.transformRadius(point, radius) * getScaleFieldToScreenRatio();
    }

    public double computeAngleRotation(Point firstPosition, Point secondPosition) {
        return _transformationSpace.computeAngleRotation(firstPosition, secondPosition);
    }

    public Point translatePointInCircleOnTopCornerSquare(Point positionRender, double radius, double angle) {
        return _transformationSpace.translatePointInCircleOnTopCornerSquare(positionRender, radius, angle);
    }

    public Point computeAngleFromAPosition(Point origin, Point myPosition) {
        double originX = origin.x / getScaleFieldToScreenRatio();
        double originY = origin.y / getScaleFieldToScreenRatio();
        double myPositionX = myPosition.x / getScaleFieldToScreenRatio();
        double myPositionY = myPosition.y / getScaleFieldToScreenRatio();
        return _transformationSpace.computeAngleFromAPosition(
                new Point(originX, originY), new Point(myPositionX, myPositionY)
        );
    }

    private double getScaleFieldToScreenRatio() {
        return _widthScreen / _transformationSpace.getWidthSpace();
    }

}
