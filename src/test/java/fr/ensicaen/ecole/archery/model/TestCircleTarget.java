package fr.ensicaen.ecole.archery.model;

import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.target.CircleTarget;
import fr.ensicaen.ecole.archery.model.target.Target;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircleTarget {

    private final Target _targetMax3 = new CircleTarget(new Point(0, 0), 3, 100);
    private final Target _targetMax10 = new CircleTarget(new Point(0, 0), 10, 100);

    private final MockProjectileTest _mockProjectileTestScore0_1 = new MockProjectileTest(new Point (100, 100));
    private final MockProjectileTest _mockProjectileTestScore0_2 = new MockProjectileTest(new Point (-100, 100));
    private final MockProjectileTest _mockProjectileTestScore1 = new MockProjectileTest(new Point (60, 60));
    private final MockProjectileTest _mockProjectileTestScore2 = new MockProjectileTest(new Point (30, 30));
    private final MockProjectileTest _mockProjectileTestScore3 = new MockProjectileTest(new Point (5, 5));

    private final MockProjectileTest _mockProjectileTestLimit1 = new MockProjectileTest(new Point (100, 0));
    private final MockProjectileTest _mockProjectileTestLimit2 = new MockProjectileTest(
            new Point (50 * Math.sqrt(2), 50 * Math.sqrt(2))
    );
    private final MockProjectileTest _mockProjectileTestLimit3 = new MockProjectileTest(
            new Point (50 * Math.sqrt(2) - 1, 50 * Math.sqrt(2) - 1)
    );
    private final MockProjectileTest _mockProjectileTestLimit4 = new MockProjectileTest(
            new Point (Double.MAX_VALUE, -Double.MAX_VALUE)
    );

    static class MockProjectileTest implements Projectile {

        final Point _position;

        public MockProjectileTest(Point position) {
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
        assertEquals(1, _targetMax3.computesPoint(_mockProjectileTestScore1));
        assertEquals(3, _targetMax3.computesPoint(_mockProjectileTestScore3));
        assertEquals(2, _targetMax3.computesPoint(_mockProjectileTestScore2));
        assertEquals(2, _targetMax10.computesPoint(_mockProjectileTestScore1));
        assertEquals(10, _targetMax10.computesPoint(_mockProjectileTestScore3));
        assertEquals(6, _targetMax10.computesPoint(_mockProjectileTestScore2));
    }

    @Test
    public void test_circle_target_computes_score_null_when_arrow_does_not_match() {
        assertEquals(0, _targetMax3.computesPoint(_mockProjectileTestScore0_1));
        assertEquals(0, _targetMax3.computesPoint(_mockProjectileTestScore0_2));
        assertEquals(0, _targetMax10.computesPoint(_mockProjectileTestScore0_1));
        assertEquals(0, _targetMax10.computesPoint(_mockProjectileTestScore0_2));
    }

    @Test
    public void test_circle_target_computes_score_on_limits() {
        assertEquals(0, _targetMax10.computesPoint(_mockProjectileTestLimit1));
        assertEquals(0, _targetMax3.computesPoint(_mockProjectileTestLimit1));
        assertEquals(0, _targetMax10.computesPoint(_mockProjectileTestLimit2));
        assertEquals(0, _targetMax3.computesPoint(_mockProjectileTestLimit2));
        assertEquals(1, _targetMax10.computesPoint(_mockProjectileTestLimit3));
        assertEquals(1, _targetMax3.computesPoint(_mockProjectileTestLimit3));
        assertEquals(0, _targetMax10.computesPoint(_mockProjectileTestLimit4));
        assertEquals(0, _targetMax3.computesPoint(_mockProjectileTestLimit4));
    }

}
