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

<<<<<<< HEAD
    public Point project3DPointTo2D(Point position) {
        double renderX = _widthSpace / 2 + (position.x - _widthSpace / 2) / position.z;
        double renderY = _heightSpace / 2 - (position.y - _heightSpace / 2) / position.z;
=======
    public double getHeightScreen() {
        return _heightScreen;
    }

    public Point transformModelPositionToViewPosition(Point modelPosition) {
        double renderX = _widthSpace / 2 + _zCam * (modelPosition.x - _widthSpace / 2) / modelPosition.z;
        double renderY = _heightSpace / 2 - _zCam * (modelPosition.y - _heightSpace / 2) / modelPosition.z;
        renderX *= getScaleFieldToScreenRatio();
        renderY *= getScaleFieldToScreenRatio();
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
        return new Point(renderX, renderY);
    }

    public double transformRadius(Point modelPosition, double radius) {
        return (radius / modelPosition.z * _zCam) * getScaleFieldToScreenRatio();
    }

<<<<<<< HEAD
    public double computeAngleRotationBetweenTwoPoints(Point firstPosition, Point secondPosition) {
        double dx = firstPosition.x - secondPosition.x;
        double dy = firstPosition.y - secondPosition.y;
        double angle = Math.toDegrees(Math.atan2(dy, dx));
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    /**
     * This function is very specific and difficult to understand
     * For an example, we suppose we have a squared image with an item in here, like an arrow
     * This item can rotate in the image, so if we put inc in the corner of the item, when
     * the item does a complete turn, we drew a circle.
     * Now let's suppose that the corner where we put inc is the main Position (arrow's peak),
     * we want to translate that position in the default position of an image which is (0, 0)
     * This is all the purpose of this function
     * @param position The position of the square
     * @param radius The radius in the circle which is in the square
     * @param angle The angle of the main point in the circle we want to translate
     * @return the new translated point
     */
    public Point translatePointInCircleOnTopCornerSquare(Point position, double radius, double angle) {
        position.x -= radius / 2 + Math.cos(angle) * (radius / 2);
        position.y -= radius / 2 + Math.sin(angle) * (radius / 2);
        return position;
    }

    public Point computeAngleXAndAngleYBetweenTwoPoints(Point origin, Point myPosition) {
        final double minRotationAngle = 5 * -Math.PI / 6;
        final double maxRotationAngle = -Math.PI / 6;

        double deltaX = _widthSpace / 2 - myPosition.x;
        double deltaY = origin.y - myPosition.y;
        double rotationAngle = -Math.atan2(deltaX , deltaY) -Math.PI / 2;
        if (rotationAngle > maxRotationAngle ) {
            rotationAngle = maxRotationAngle;
        }
        if (rotationAngle <  minRotationAngle) {
            rotationAngle = minRotationAngle;
        }
        return new Point(computeAngleX(rotationAngle), computeAngleY(myPosition.y), rotationAngle);
    }

    private double computeAngleX(double rotationAngle) {
        final double minRotationAngle = -Math.PI / 3;
        final double maxRotationAngle = Math.PI / 3;

        double angleX = rotationAngle + Math.PI / 2;
        if (angleX > maxRotationAngle) {
            angleX = maxRotationAngle;
        }
        if (angleX < minRotationAngle) {
            angleX =  minRotationAngle;
        }
        return angleX;
    }

    private double computeAngleY(double y) {
        final double limitAngle = Math.PI / 4;
        return (_heightSpace - y) * limitAngle / _heightSpace;
=======
    private double getScaleFieldToScreenRatio() {
        return _widthScreen / _widthSpace;
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

}
