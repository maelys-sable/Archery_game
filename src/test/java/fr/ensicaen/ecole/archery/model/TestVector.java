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

import fr.ensicaen.ecole.archery.model.space.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVector {

    @Test
    public void test_vector_multiply_by_scalar() {
        Vector vector = new Vector(5, 10, 25);
        vector = vector.multiplyByScalar(2);
        assertEquals(10, vector.getX(), 0.001);
        assertEquals(20, vector.getY(), 0.001);
        assertEquals(50, vector.getZ(), 0.001);

        vector = new Vector(5, 10, 25);
        vector = vector.multiplyByScalar(-2);
        assertEquals(-10, vector.getX(), 0.001);
        assertEquals(-20, vector.getY(), 0.001);
        assertEquals(-50, vector.getZ(), 0.001);

        vector = new Vector(5, 10, 25);
        vector = vector.multiplyByScalar(0.5);
        assertEquals(2.5, vector.getX(), 0.001);
        assertEquals(5, vector.getY(), 0.001);
        assertEquals(12.5, vector.getZ(), 0.001);
    }

    @Test
    public void test_vector_norm() {
        Vector vector = new Vector(1, 2, 3);
        assertEquals(vector.norm(), Math.sqrt(14), 0.001);

        vector = new Vector(-1, -2, 3);
        assertEquals(vector.norm(), Math.sqrt(14), 0.001);

        vector = new Vector(0, 0, 0);
        assertEquals(vector.norm(), 0, 0.001);
    }

    @Test
    public void test_vector_normalise() {
        Vector vector = new Vector(1, 2, 3);
        vector = vector.normalise();
        assertEquals(1, vector.norm(), 0.001);

        vector = new Vector(10, 5, -5);
        vector = vector.normalise();
        assertEquals(1, vector.norm(), 0.001);

        vector = new Vector(0.1, 0.2, 0.3);
        vector = vector.normalise();
        assertEquals(1, vector.norm(), 0.001);
    }

    @Test
    public void test_vector_normalise_on_limit_zero() {
        Vector vectorNull = new Vector(0, 0, 0);
        assertThrows(RuntimeException.class, vectorNull::normalise, "Vector normalise error, norm null !");
    }

}
