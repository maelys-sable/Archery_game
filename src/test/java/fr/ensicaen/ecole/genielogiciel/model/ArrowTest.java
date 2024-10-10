package fr.ensicaen.ecole.genielogiciel.model;
import fr.ensicaen.ecole.archery.model.Arrow;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ArrowTest {

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
    public void testInvalidAngleXLow() {
        try {
            // Test avec un angle X inférieur à -60° (devrait lancer une exception)
            new Arrow(-70, 0, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleX", e.getMessage());
        }
    }

    @Test
    public void testInvalidAngleYHigh() {
        try {
            // Test avec un angle Y supérieur à 60° (devrait lancer une exception)
            new Arrow(0, 70, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void testInvalidAngleYLow() {
        try {
            // Test avec un angle Y inférieur à -60° (devrait lancer une exception)
            new Arrow(0, -70, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect angleY", e.getMessage());
        }
    }

    @Test
    public void testNegativePower() {
        try {
            // Test avec une puissance négative (devrait lancer une exception)
            new Arrow(30, 30, -10);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect power", e.getMessage());
        }
    }
}

