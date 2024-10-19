package fr.ensicaen.ecole.archery.model;

import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.target.CircleTarget;
import fr.ensicaen.ecole.archery.model.target.Target;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircleTarget {

    private final Target _target = new CircleTarget(new Point(0, 0), 3, 100);
    private final ProjectileTest _projectileTestScore0_1 = new ProjectileTest(new Point (100, 100));
    private final ProjectileTest _projectileTestScore0_2 = new ProjectileTest(new Point (-100, 100));
    private final ProjectileTest _projectileTestScore1 = new ProjectileTest(new Point (80, 80));
    private final ProjectileTest _projectileTestScore2 = new ProjectileTest(new Point (30, 30));
    private final ProjectileTest _projectileTestScore3 = new ProjectileTest(new Point (5, 5));

    class ProjectileTest implements Projectile {

        final Point _position;

        public ProjectileTest(Point position) {
            _position = position;
        }

        @Override
        public double getPower() {
            return 0;
        }

        @Override
        public Point computePositionFromDistance(double z) {
            return _position;
        }

        @Override
        public double distanceWhereProjectileStopped() {
            return 0;
        }

        @Override
        public void setDistanceWhereProjectileHitTarget(double finalDistance) {
        }

    }

    @Test
    public void test_circle_target_computes_score_when_arrow_match() {
        assertEquals(1, _target.computesPoint(_projectileTestScore1));
        assertEquals(3, _target.computesPoint(_projectileTestScore3));
        assertEquals(2, _target.computesPoint(_projectileTestScore2));
    }

    @Test
    public void test_circle_target_computes_score_null_when_arrow_does_not_match() {
        assertEquals(0, _target.computesPoint(_projectileTestScore0_1));
        assertEquals(0, _target.computesPoint(_projectileTestScore0_2));
    }

}
