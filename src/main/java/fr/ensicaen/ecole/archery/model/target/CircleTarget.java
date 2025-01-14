package fr.ensicaen.ecole.archery.model.target;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import fr.ensicaen.ecole.archery.model.space.Point;

/**
 * A Circle Target
 */
public class CircleTarget implements Target {

    private final int _numberOfSections;
    private final double _radius;
    private final Point _position;

    public CircleTarget(Point position, int numberOfSections, double radius) {
        _position = position;
        _numberOfSections = numberOfSections;
        _radius = radius;
    }

    @Override
    public int getNumberOfSections() {
        return _numberOfSections;
    }

    @Override
    public double getRadius() {
        return _radius;
    }

    @Override
    public Point getPosition() {
        return _position;
    }

    @Override
    public int computesPoint(Projectile projectile) {
        Point finalPositionOfProjectile = projectile.computePositionFromDistance(_position.z);
        double distance = distanceBetweenTwoPoints(_position, finalPositionOfProjectile);
        if (distance >= _radius) {
            return 0;
        }
        projectile.setDistanceWhereProjectileHitTarget(_position.z);
        return (int) (_numberOfSections - (distance / _radius * _numberOfSections)) + 1;
    }

    private double distanceBetweenTwoPoints(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
