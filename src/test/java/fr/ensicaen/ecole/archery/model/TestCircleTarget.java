package fr.ensicaen.ecole.archery.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircleTarget {

    class ProjectileTest implements Projectile {

        final Point _position;

        public ProjectileTest(Point position) {
            _position = position;
        }

        @Override
        public Point getPosition(double z) {
            return _position;
        }

        @Override
        public double getFinalDistance() {
            return 0;
        }

        @Override
        public void setFinalDistance(double finalDistance) {
        }

    }

    @Test
    public void test_circle_target_computes_point() {
        Target target = new CircleTarget(3, 100, 50, new Point(0, 0));
        assertEquals(0, target.computesPoint(new ProjectileTest(new Point (80, 80))));
        assertEquals(3, target.computesPoint(new ProjectileTest(new Point (5, 5))));
        assertEquals(2, target.computesPoint(new ProjectileTest(new Point (50, 50))));
        assertEquals(1, target.computesPoint(new ProjectileTest(new Point (60, 60))));
        assertEquals(0, target.computesPoint(new ProjectileTest(new Point (100, 0))));
    }

}
