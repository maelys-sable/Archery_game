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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ArrowTest {

    @Test
    public void test_valid_arrow_creation(){
        Arrow arrow = new Arrow(new Point(0, 1.5),0,0,50);
        Point position = arrow.getPosition(0);
        assertEquals(0, position.x, 0.1);
        assertEquals(1.5, position.y, 0.1);

        position = arrow.getPosition(arrow.getFinalDistance());
        assertEquals(0, position.x, 0.1);
        assertEquals(0, position.y,0.1);
    }

    @Test
    public void test_invalid_angle_X_high(){
        try {
            new Arrow(new Point(0, 1.5), Math.PI / 2,0, 10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX",e.getMessage());
        }
    }

    @Test
    public void test_invalid_angle_X_low() {
        try {
            new Arrow(new Point(0, 1.5),-Math.PI / 2, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX", e.getMessage());
        }
    }

    @Test
    public void test_invalid_angle_Y_high() {
        try {
            new Arrow(new Point(0, 1.5), 0, Math.PI / 2, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void test_invalid_angle_Y_low() {
        try {
            new Arrow(new Point(0, 1.5), 0, -Math.PI / 2, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void test_negative_power() {
        try {
            new Arrow(new Point(0, 1.5), 0, 0,  -10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }

    @Test
    public void test_excessive_power() {
        try {
            new Arrow(new Point(0, 1.5), 0, 0,  2000);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }

    @Test
    public void test_valid_angles() {
        Arrow arrow = new Arrow(new Point(0, 1.5), 0, 0, 500);
        assertEquals(17.4, arrow.getFinalDistance(),0.1);
        Point position = arrow.getPosition(20);
        assertEquals(0, position.x, 0.1);
        assertEquals(1, position.y,0.1);
    }


}

