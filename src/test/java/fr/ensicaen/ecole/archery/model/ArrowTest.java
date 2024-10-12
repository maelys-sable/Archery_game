package fr.ensicaen.ecole.archery.model;

import fr.ensicaen.ecole.archery.model.Arrow;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ArrowTest {

    @Test
    public void Test_valid_arrow_creation(){
        Arrow arrow = new Arrow(0,0,0,0,50);
        Point position = arrow.getPosition(0);
        assertEquals(0, position.x);
        assertEquals(0, position.y);
        position = arrow.getPosition(arrow.getFinalDistance());
        assertEquals(0, position.x, 0.1);
        assertEquals(0, position.y,0.1);
    }

    @Test
    public void test_invalid_angle_x_high(){
        try {
            new Arrow(Math.PI / 2,0, 0, 0, 10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX",e.getMessage());
        }
    }
    @Test
    public void test_invalid_angle_x_low() {
        try {
            new Arrow(-Math.PI / 2, 0, 0, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX", e.getMessage());
        }
    }

    @Test
    public void test_invalid_angle_y_high() {
        try {
            new Arrow(0, Math.PI / 2, 0, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void test_invalid_angle_y_low() {
        try {
            new Arrow(0, -Math.PI / 2, 0, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void test_negative_power() {
        try {
            new Arrow(0, 0, 0, 0,  -10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }

    @Test
    public void test_excessive_power() {
        try {
            new Arrow(0, 0, 0, 0,  2000);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }

    @Test
    public void test_valid_angles() {
        Arrow arrow = new Arrow(0, 0, 0, 0, 100);
        assertEquals();
    }


}

