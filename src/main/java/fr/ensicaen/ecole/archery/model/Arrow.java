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

    private final double _vx0;          // component of the initial speed vector on axis X
    private final double _vy0;          // component of the initial speed vector on axis Y
    private final double _vz0;          // component of the initial speed vector on axis Z
    private static final double _GRAVITATIONAL_CONSTANT = 9.81;
    private static final double MAX_ANGLE = Math.PI / 3;
    private final double _X0;
    private final double _Y0;
    private double _finalDistance;

    public Arrow(double angleX, double angleY, double X0, double Y0, double power) {

        _Y0 = Y0;
        _X0 = X0;
        double v0 = getV0(angleX, angleY, power);
        _finalDistance = calculateFinalDistance();

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

    private double getV0(double angleX, double angleY, double power) {

        if (angleX > MAX_ANGLE || angleX < -MAX_ANGLE ) {
                throw new IllegalArgumentException("Incorrect angleX");
        }

        if (angleY > MAX_ANGLE || angleY < -MAX_ANGLE ) {
            throw new IllegalArgumentException("Incorrect angleY");
        }

        if (power < 0 || power > 1500) {
            throw new IllegalArgumentException("Incorrect power");
        }

        double mass = 0.02;    // mass of the arrow
        double accelerationDuration = 0.2;     // time during which the arrow is subjected to the force
        return accelerationDuration * Math.sqrt(power / mass);
    }

    private double calculateX(double depth) {
        return _vx0 * depth / _vz0 + _X0;
    }
    private double calculateY(double depth) {
        return -0.5 * _GRAVITATIONAL_CONSTANT * depth /_vz0 * depth /_vz0 + _vy0 * depth / _vz0 + _Y0;
    }
    private double calculateFinalDistance(){
        double timeToHitGround = (_vy0 +Math.sqrt(_vy0*_vy0 - 2 * _GRAVITATIONAL_CONSTANT * _Y0))/ _GRAVITATIONAL_CONSTANT;
        return _vz0 * timeToHitGround ;
    }
    public Point getPosition(double depth) {
        Point position = new Point();
        position.setLocation(calculateX(depth), calculateY(depth));
        return position;

    }

    public double get_finalDistance() {
        return _finalDistance;
    }

    public void set_finalDistance(double finaldistance) {
        _finalDistance = finaldistance;
    }
}
