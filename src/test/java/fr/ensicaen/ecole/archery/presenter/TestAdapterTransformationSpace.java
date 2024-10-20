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

    private final AdapterTransformationSpace _space = new AdapterTransformationSpace(640, 360, 1);

    @Test
    public void test_project_3DPoint_to_2DPoint() {
        Point positionInDomain = new Point(0, 0, 1);
        Point positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(0, positionInScreen.x, 0.0001);
        assertEquals(360, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.5, 0.5, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(320, positionInScreen.x, 0.0001);
        assertEquals(40, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.8, 1);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(128, positionInScreen.x, 0.0001);
        assertEquals(-152, positionInScreen.y, 0.0001);

        positionInDomain = new Point(0.2, 0.2, 5);
        positionInScreen = _space.project3DPointTo2D(positionInDomain);
        assertEquals(281.6, positionInScreen.x, 0.0001);
        assertEquals(190.4, positionInScreen.y, 0.0001);
    }

    @Test
    public void test_transform_radius() {
        Point positionInDomain = new Point(0, 0, 1);
        double renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(320, renderPosition, 0.0001);

        positionInDomain = new Point(0, 0, 5);
        renderPosition = _space.transformRadius(positionInDomain, 0.5);
        assertEquals(64, renderPosition, 0.0001);
    }

    @Test
    public void test_compute_angle_x_and_angle_y_between_two_points() {
        Point origin = new Point(0.5, 0, 1);
        Point position = new Point(0.5, 0.5, 1);
        Point angles = _space.computeAngleXAndAngleYBetweenTwoPoints(origin, position);
        assertEquals(0.7814, angles.y, 0.01);
    }

}
