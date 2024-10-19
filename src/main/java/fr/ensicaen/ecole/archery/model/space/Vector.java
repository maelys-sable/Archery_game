package fr.ensicaen.ecole.archery.model.space;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


/**
 * Characterization of Vectors
 */
public class Vector {

    private double _x;
    private double _y;
    private double _z;

    public Vector(double x, double y) {
        _x = x;
        _y = y;
        _z = 0;
    }

    public Vector(double x,double y,double z){
        _x = x;
        _y = y;
        _z = z;
    }

    public Vector multiplyByScalar(double scalar) {
        return new Vector(_x * scalar, _y * scalar, _z * scalar);
    }

    public double norm() {
        return Math.sqrt(_x * _x + _y * _y + _z * _z);
    }

    public Vector normalise() {
        double normValue = norm();
        if (normValue == 0.0) {
            throw new RuntimeException("Vector normalise error, norm null !");
        }
        return new Vector(_x / normValue, _y / normValue, _z /normValue);
    }

    public void setNull(){
        _x = 0;
        _y = 0;
        _z = 0;
    }

    public void add(Vector v) {
        _x += v.getX();
        _y += v.getY();
        _z += v.getZ();
    }
    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public double getZ() {
        return _z;
    }


}
