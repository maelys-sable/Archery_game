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

    private final double _widthSpace;
    private final double _heightSpace;
    private final double _zCam = 1;

    public TransformationSpace(double widthSpace, double heightSpace) {
        _widthSpace = widthSpace;
        _heightSpace = heightSpace;
    }

    public double getWidthSpace() {
        return _widthSpace;
    }

    public double getHeightSpace() {
        return _heightSpace;
    }

    public Point project3DPointTo2D(Point position) {
        double renderX = _widthSpace / 2 + _zCam * (position.x - _widthSpace / 2) / position.z;
        double renderY = _heightSpace / 2 - _zCam * (position.y - _heightSpace / 2) / position.z;
        return new Point(renderX, renderY);
    }

    public double transformRadius(Point position, double radius) {
        return radius / position.z * _zCam;
    }

    public double computeAngleRotation(Point firstPosition, Point secondPosition) {
        double dx = firstPosition.x - secondPosition.x;
        double dy = firstPosition.y - secondPosition.y;
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
        double deltaX = _widthSpace / 2 - myPosition.x;
        double deltaY = origin.y - myPosition.y;
        double rotationAngle = -Math.atan2(deltaX , deltaY) -Math.PI / 2;
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
        return (_heightSpace - y) * Math.PI / (4 * _heightSpace);
    }

}
