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

public class Arrow implements Projectile {

    private final double _Z0 = 0;       // initial position on Z axis
    private final double _vx0;          // component of the initial speed vector on axis X
    private final double _vy0;          // component of the initial speed vector on axis Y
    private final double _vz0;          // component of the initial speed vector on axis Z

    public Arrow(double angleX, double angleY, double power) {

        if (angleX > 60 || angleX < -60 ) {
                throw new IllegalArgumentException("Incorrect angleX");
        }

        if (angleY > 60 || angleY < -60 ) {
            throw new IllegalArgumentException("Incorrect angleY");
        }

        if (power < 0 ) {
            throw new IllegalArgumentException("Incorrect power");
        }

        double mass = 0.02;    // mass of the arrow
        double time = 0.2;     // time during which the arrow is subjected to the force
        double v0 = time * Math.sqrt(power / mass);         // norm of the initial speed vector

        //  Let's calculate the unit vector

        //  Here is a vector (vx,vy,vz) with the same orientation as v0
        double vx = v0 * Math.sin(angleX) * Math.cos(angleY);
        double vy = v0 * Math.cos(angleX) * Math.sin(angleY);
        double vz = v0 * Math.cos(angleX) * Math.cos(angleY);

        //  Let's normalize this vector

        double norm = Math.sqrt(vx * vx + vy * vy + vz * vz);
        double ux = vx / norm;
        double uy = vy / norm;
        double uz = vz / norm;

        //  So (ux,uy,uz) is a unit vector with the same orientation as v0
        //  Let's multiply this by v0 to have our vector
        _vx0 = ux * v0;
        _vy0 = uy * v0;
        _vz0 = uz * v0;
    }

    private double getX(double depth) {
        double X0 = 0;      // initial position on X axis
        return _vx0 * (depth - _Z0) / _vz0 + X0;
    }
    private double getY(double depth) {
        double Y0 = 0;      // initial position on Y axis
        double g = 9.81;    // gravitational constant
        return -0.5 * g * (depth - _Z0)/_vz0 * (depth - _Z0)/_vz0 + _vy0 * (depth - _Z0) / _vz0 + Y0;
    }
    public Point getPosition(double depth) {
        return new (PointgetX(depth),getY(depth));
    }

}
