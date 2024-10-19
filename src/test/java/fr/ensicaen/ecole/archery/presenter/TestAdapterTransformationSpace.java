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
import fr.ensicaen.ecole.archery.presenter.component.AdapterTransformationSpace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdapterTransformationSpace {

    private final AdapterTransformationSpace _space = new AdapterTransformationSpace(100, 100, 1);

    @Test
    public void test_transform_model_position_to_view_position() {
        Point positionInDomain = new Point(0, 0, 1);
        Point positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(0, positionInScreen.x, 0.0001);
        assertEquals(100, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.5, 0.5, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(50, positionInScreen.x, 0.0001);
        assertEquals(50, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.8, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(20, positionInScreen.x, 0.0001);
        assertEquals(20, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.2, 5);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(44, positionInScreen.x, 0.0001);
        assertEquals(56, positionInScreen.y, 0.0001);
    }

    @Test
    public void test_transform_radius() {
        Point positionInDomain = new Point(0, 0, 1);
        double renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(50, renderPosition, 0.0001);

        positionInDomain = new Point(0, 0, 5);
        renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(10, renderPosition, 0.0001);
    }

    @Test
    public void test_compute_angle_rotation() {
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
        Point point = new Point(0, 0, 1);
        assertEquals(5, _space.transformRadius(point, 0.05));
        point.z = 5;
        assertEquals(1, _space.transformRadius(point, 0.05));
    }

    @Test
    public void test_compute_angle_from_a_position() {
        Point origin = new Point(0.5, 0, 1);
        Point position = new Point(0.5, 0.5, 1);
        Point angles = _space.computeAngleXAndAngleYBetweenTwoPoints(origin, position);
        assertEquals(0.7814, angles.y, 0.01);
    }

}
