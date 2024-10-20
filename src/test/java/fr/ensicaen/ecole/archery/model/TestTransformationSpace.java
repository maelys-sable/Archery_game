package fr.ensicaen.ecole.archery.model;

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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransformationSpace {

    private final TransformationSpace _space = new TransformationSpace(100, 100);

    @Test
    public void test_project_3DPoint_to_2DPoint() {
        Point positionInDomain = new Point(0, 0, 1);
        Point positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(0, positionInScreen.x, 0.0001);
        assertEquals(100, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.5, 0.5, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(0.5, positionInScreen.x, 0.0001);
        assertEquals(99.5, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.8, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(0.2, positionInScreen.x, 0.0001);
        assertEquals(99.2, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.2, 5);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(40.04, positionInScreen.x, 0.0001);
        assertEquals(59.96, positionInScreen.y, 0.0001);
    }

    @Test
    public void test_transform_radius() {
        Point positionInDomain = new Point(0, 0, 1);
        double renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(0.5, renderPosition, 0.0001);

        positionInDomain = new Point(0, 0, 5);
        renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(0.1, renderPosition, 0.0001);
    }

    @Test
    public void test_compute_angle_rotation_between_two_points() {
        Point position1 = new Point(0, 0, 1);
        Point position2 = new Point(1, 1, 1);
        assertEquals(225, _space.computeAngleRotationBetweenTwoPoints(position1, position2), 0.0001);
        assertEquals(45, _space.computeAngleRotationBetweenTwoPoints(position2, position1), 0.0001);

        position2 = new Point(1, -1, 1);
        assertEquals(135, _space.computeAngleRotationBetweenTwoPoints(position1, position2), 0.0001);
        assertEquals(315, _space.computeAngleRotationBetweenTwoPoints(position2, position1), 0.0001);
    }

    @Test
    public void test_translate_point_in_circle_on_top_corner_square() {
        Point point = new Point(50, 50);
        _space.translatePointInCircleOnTopCornerSquare(point, 10, 0);
        assertEquals(40, point.x, 0.01);
        assertEquals(45, point.y, 0.01);

        point = new Point(50, 50);
        _space.translatePointInCircleOnTopCornerSquare(point, 10, Math.PI/2);
        assertEquals(45, point.x, 0.01);
        assertEquals(40, point.y, 0.01);

        point = new Point(50, 50);
        _space.translatePointInCircleOnTopCornerSquare(point, 10, Math.PI/4);
        assertEquals(41.46, point.x, 0.01);
        assertEquals(41.46, point.y, 0.01);

        point = new Point(50, 50);
        _space.translatePointInCircleOnTopCornerSquare(point, 10, -Math.PI/4);
        assertEquals(41.46, point.x, 0.01);
        assertEquals(48.54, point.y, 0.01);
    }

    @Test
    public void test_compute_angle_x_and_angle_y_between_two_points() {
        Point origin = new Point(0.5, 0, 1);
        Point position = new Point(0.5, 0.5, 1);
        Point angles = _space.computeAngleXAndAngleYBetweenTwoPoints(origin, position);
        assertEquals(0.7814, angles.y, 0.01);
    }

}
