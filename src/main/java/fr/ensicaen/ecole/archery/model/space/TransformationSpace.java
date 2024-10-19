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

/**
 * A class for every transformation calculus we needed in a 3D space
 * It is only available in this domain
 * It is design in a way that you can use adapters on this for other domains
 */
public class TransformationSpace {

    private final double _widthSpace;
    private final double _heightSpace;

    public TransformationSpace(double widthSpace, double heightSpace) {
        _widthSpace = widthSpace;
        _heightSpace = heightSpace;
    }

    public double getWidthSpace() {
        return _widthSpace;
    }

    public Point project3DPointTo2D(Point position) {
        double renderX = _widthSpace / 2 + (position.x - _widthSpace / 2) / position.z;
        double renderY = _heightSpace / 2 - (position.y - _heightSpace / 2) / position.z;
        return new Point(renderX, renderY);
    }

    /**
     * The farther the object, the lower is radius is
     * @param position position in the 3D plan of a 3D Element
     * @param radius radius
     * @return the render radius
     */
    public double transformRadius(Point position, double radius) {
        return radius / position.z;
    }

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
    }

}
