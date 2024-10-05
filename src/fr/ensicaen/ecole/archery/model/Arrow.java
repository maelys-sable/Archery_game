package fr.ensicaen.ecole.archery.model;

import java.awt.geom.Point2D;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

public class Arrow implements Projectile {
    private final double _Z0 = 0;       // initial position on Z axis
    private final double _vx0;          // component of the initial speed vector on axis X
    private final double _vy0;          // component of the initial speed vector on axis Y
    private final double _vz0;          // component of the initial speed vector on axis Z
    public Arrow(double angleX, double angleY, double power) {
        double mass = 0.02;    // mass of the arrow
        double time = 0.2;     // time during which the arrow is subjected to the force
        double v0 = time * Math.sqrt(power / mass);         // norm of the initial speed vector
        _vx0 = v0 * Math.sin(angleX) * Math.cos(angleY);
        _vy0 = v0 * Math.cos(angleX) * Math.sin(angleY);
        _vz0 = v0 * Math.cos(angleX) * Math.cos(angleY);

    }
    private double getX(double depth) {
        double X0 = 0;      // initial position on X axis
        return _vx0 * (depth - _Z0) / _vz0 + X0;
    }
    private double getY(double depth) {
        double Y0 = 0;      // initial position on Y axis
        double g = 9.81;    // gravitational constant
        return -0.5 * g * Math.pow((depth - _Z0)/_vz0 , 2) + _vy0 * (depth - _Z0) / _vz0 + Y0;
    }
    public Point2D.Double get_position(double depth) {
        return new Point2D.Double(getX(depth),getY(depth));
    }

}
