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


import java.awt.Point;


public class CircleTarget implements Target {

    private int _numberOfSections;
    private int _radius;
    private int _distance;
    private Point _position;

    public CircleTarget(int numberOfSections, int radius, int distance, Point position) {
        _numberOfSections = numberOfSections;
        _radius = radius;
        _distance = distance;
        _position = position;
    }

    @Override
    public int getNumberOfSections() {
        return _numberOfSections;
    }

    @Override
    public int getRadius() {
        return _radius;
    }

    @Override
    public int getDistance() {
        return _distance;
    }

    @Override
    public Point getPosition() {
        return _position;
    }

    @Override
    public int computesPoint(Projectile projectile) {
        Point finalPositionOfProjectile = projectile.getPosition(_distance);
        double distance = distanceBewtweenTwoPointsSquared(_position, finalPositionOfProjectile);
        if (distance >= _radius * _radius) {
            return 0;
        }
        return _numberOfSections - (int) (distance / (_radius * _radius) * _numberOfSections);
    }

    private double distanceBewtweenTwoPointsSquared(Point a, Point b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return dx * dx + dy * dy;
    }

}
