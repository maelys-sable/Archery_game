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

public class Arrow implements Projectile {

    private final Vector _initialSpeed;
    private static final double GRAVITATIONAL_CONSTANT = 9.81;
    private static final double MAX_ANGLE = Math.PI / 3;
    private final double _X0;
    private final double _Y0;
    private double _finalDistance;

    public Arrow(double angleX, double angleY, double X0, double Y0, double power) {

        _Y0 = Y0;
        _X0 = X0;
        double v0 = getV0(angleX, angleY, power);
        _finalDistance = calculateFinalDistance();


        //  Here is a vector (vx,vy,vz) with the same orientation as v0
        double vx = v0 * Math.sin(angleX) * Math.cos(angleY);
        double vy = v0 * Math.cos(angleX) * Math.sin(angleY);
        double vz = v0 * Math.cos(angleX) * Math.cos(angleY);
        Vector direction = new Vector(vx, vy, vz);

        //  Let's normalize this vector
        Vector normalisedVector = direction.normalise();

        _initialSpeed = normalisedVector.multiplyByScalar(v0);

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
        return _initialSpeed.getx() * depth / _initialSpeed.getz() + _X0;
    }
    private double calculateY(double depth) {
        return -0.5 * GRAVITATIONAL_CONSTANT * depth / _initialSpeed.getz() * depth / _initialSpeed.getz() + _initialSpeed.gety() * depth / _initialSpeed.getz() + _Y0;
    }
    private double calculateFinalDistance(){
        double timeToHitGround = (_initialSpeed.gety() + Math.sqrt(_initialSpeed.gety() * _initialSpeed.gety() - 2 * GRAVITATIONAL_CONSTANT * _Y0))/ GRAVITATIONAL_CONSTANT;
        return _initialSpeed.getz()  * timeToHitGround ;
    }
    public Point getPosition(double depth) {
        return new Point(calculateX(depth),calculateY(depth));
    }

    public double getFinalDistance() {
        return _finalDistance;
    }

    public void setFinalDistance(double finalDistance) {
        _finalDistance = finalDistance;
    }
}
