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


/**
 * This is an adapter of the space transformation in model domain into the screen domain
 */
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

    /**
     * The farther the object, the lower is radius is
     * @param position position in the 3D plan of a 3D Element
     * @param radius radius
     * @return the render radius
     */
    public double transformRadius(Point position, double radius) {
        return _transformationSpace.transformRadius(position, radius) * getScaleFieldToScreenRatio();
    }

    public double computeAngleRotationBetweenTwoPoints(Point firstPosition, Point secondPosition) {
        return _transformationSpace.computeAngleRotationBetweenTwoPoints(firstPosition, secondPosition);
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
        return _transformationSpace.translatePointInCircleOnTopCornerSquare(position, radius, angle);
    }

    public Point computeAngleXAndAngleYFromAPosition(Point origin, Point myPosition) {
        double originX = origin.x / getScaleFieldToScreenRatio();
        double originY = origin.y / getScaleFieldToScreenRatio();
        double myPositionX = myPosition.x / getScaleFieldToScreenRatio();
        double myPositionY = myPosition.y / getScaleFieldToScreenRatio();
        return _transformationSpace.computeAngleXAndAngleYFromAPosition(
                new Point(originX, originY), new Point(myPositionX, myPositionY)
        );
    }

    private double getScaleFieldToScreenRatio() {
        return _widthScreen / _transformationSpace.getWidthSpace();
    }

}
