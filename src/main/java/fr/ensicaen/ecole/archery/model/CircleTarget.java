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
        Point finalPositionOfProjectile = projectile.getPosition(_position.z);
        System.out.println("COUNTING POINTS");

        double distance = distanceBetweenTwoPointsSquared(_position, finalPositionOfProjectile);
        System.out.println("distance" + distance);

        if (distance >= _radius * _radius) {
            return 0;
        }
        projectile.setFinalDistance(_position.z);
        return (int) (_numberOfSections - (distance / (_radius * _radius) * _numberOfSections));
    }

    private double distanceBetweenTwoPointsSquared(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

}
