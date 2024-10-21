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

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.projectile.Arrow;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.target.Target;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShooter {

    static class TestShooterBow extends Bow {

        public TestShooterBow() {
            super(new Point(0, 0), 500, 0.1, 5);
        }

        @Override
        public Projectile createProjectile() {
            return new Arrow(new Point(0, 1.5),0,0,50);
        }

    }

    static class TestShooterTarget implements Target {

        @Override
        public int computesPoint(Projectile projectile) {
            return 10;
        }

        @Override
        public int getNumberOfSections() {
            return 5;
        }

        @Override
        public double getRadius() {
            return 5;
        }

        @Override
        public Point getPosition() {
            return null;
        }

    }

    private final TestShooterBow _shooterBowTest = new TestShooterBow();
    private final TestShooterTarget _shooterTargetTest = new TestShooterTarget();


    @Test
    public void test_shooter_shoot() {
        _shooterBowTest.setPower(500);
        Shooter shooter = new Shooter(_shooterTargetTest, _shooterBowTest, 2);
        shooter.shoot();
        _shooterBowTest.setPower(500);
        assertEquals(10, shooter.getScore());
        assertEquals(1, shooter.getNumberOfProjectiles());
        shooter.shoot();
        _shooterBowTest.setPower(500);
        assertEquals(20, shooter.getScore());
        assertEquals(0, shooter.getNumberOfProjectiles());
    }

    @Test
    public void test_shooter_shoot_when_no_arrow() {
        _shooterBowTest.setPower(500);
        Shooter shooter = new Shooter(_shooterTargetTest, _shooterBowTest, 1);
        shooter.shoot();
        _shooterBowTest.setPower(500);
        assertEquals(10, shooter.getScore());
        assertEquals(0, shooter.getNumberOfProjectiles());
        shooter.shoot();
        _shooterBowTest.setPower(500);
        assertEquals(10, shooter.getScore());
        assertEquals(0, shooter.getNumberOfProjectiles());
    }

    @Test
    public void test_shooter_shoot_when_not_enough_power() {
        _shooterBowTest.setPower(10);
        Shooter shooter = new Shooter(_shooterTargetTest, _shooterBowTest, 20);
        assertNull(shooter.shoot());
        assertEquals(0, shooter.getScore());
        _shooterBowTest.setPower(500);
        assertNotNull(shooter.shoot());
        assertEquals(10, shooter.getScore());
    }

    @Test
    public void test_shooter_reset() {
        _shooterBowTest.setPower(500);
        Shooter shooter = new Shooter(_shooterTargetTest, _shooterBowTest, 100);
        shooter.shoot();
        _shooterBowTest.setPower(500);
        assertNotEquals(0, shooter.getScore());
        assertNotEquals(100, shooter.getNumberOfProjectiles());
        shooter.reset();
        _shooterBowTest.setPower(500);
        assertEquals(0, shooter.getScore());
        assertEquals(100, shooter.getNumberOfProjectiles());
    }

}
