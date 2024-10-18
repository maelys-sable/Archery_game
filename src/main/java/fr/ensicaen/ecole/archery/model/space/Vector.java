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

public class Vector {

    private final double _x;
    private final double _y;
    private final double _z;

    public Vector(double x,double y,double z){
        _x = x;
        _y = y;
        _z = z;
    }
    public Vector(Point start, Point end){
        _x = end.x - start.x;
        _y = end.y - start.y;
        _z = end.z - start.z;
    }

    public Vector multiplyByScalar(double scalar){
        return new Vector(_x * scalar, _y * scalar, _z * scalar);
    }

    public double norm(){
        return Math.sqrt(_x * _x + _y * _y + _z * _z);
    }

    public Vector normalise(){
        double normValue = norm();
        return new Vector(_x / normValue, _y / normValue, _z /normValue);
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
