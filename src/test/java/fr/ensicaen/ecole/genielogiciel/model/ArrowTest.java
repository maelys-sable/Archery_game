package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.archery.model.Arrow;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ArrowTest {

    @Test
    public void TestValidArrowCreation(){
        Arrow arrow = new Arrow(30,-30,50);
        Point position = arrow.getPosition(0);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void TestInvalidAngleXHigh(){
        try {
            new Arrow(70,10,10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX",e.getMessage());
        }
    }
    @Test
    public void TestInvalidAngleXLow() {
        try {
            new Arrow(-70, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX", e.getMessage());
        }
    }

    @Test
    public void TestInvalidAngleYHigh() {
        try {
            new Arrow(0, 70, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void TestInvalidAngleYLow() {
        try {
            new Arrow(0, -70, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void TestNegativePower() {
        try {
            new Arrow(30, 30, -10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }
}

