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

    public double computeAngleRotation(Point position1, Point position2) {
        double dx = position1.x - position2.x;
        double dy = position1.y - position2.y;
        double angle = Math.toDegrees(Math.atan2(dy, dx));
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    public Point translatePointInCircleOnTopCornerSquare(Point positionRender, double radius, double angle) {
        positionRender.x -= radius / 2 + Math.cos(angle) * (radius / 2);
        positionRender.y -= radius / 2 + Math.sin(angle) * (radius / 2);
        return positionRender;
    }

    public Point computeAngleFromAPosition(Point origin, Point myPosition) {
        double deltaX = getWidthScreen() / 2 - myPosition.x;
        double deltaY = origin.y - myPosition.y;
        double rotationAngle = -Math.atan2(deltaX , deltaY) -Math.PI / 2 ;

        if (rotationAngle > -Math.PI / 6 ) {
            rotationAngle = -Math.PI / 6;
        }
        if (rotationAngle < 5 * -Math.PI / 6 ) {
            rotationAngle = 5 * -Math.PI / 6;
        }
        return new Point(computeAngleX(rotationAngle), computeAngleY(myPosition.y), rotationAngle);
    }

    private double computeAngleX(double rotationAngle) {
        double angleX = rotationAngle + Math.PI / 2;
        if (angleX > Math.PI / 3 ) {
            angleX = Math.PI / 3;
        }
        if (angleX < -Math.PI / 3 ) {
            angleX =  -Math.PI / 3;
        }
        return angleX;
    }

    private double computeAngleY(double y) {
        return (getHeightScreen() - y) * Math.PI / (4 * getHeightScreen());
    }

    private double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
    }

}
