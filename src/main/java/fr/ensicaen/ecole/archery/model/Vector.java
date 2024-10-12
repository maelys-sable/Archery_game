package fr.ensicaen.ecole.archery.model;

public class Vector {
    private final double _x;
    private final double _y;
    private final double _z;

    public Vector(double x,double y,double z){
        _x = x;
        _y = y;
        _z = z;
    }
    public Vector (Point start, Point end){
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
        double norm = this.norm();
        return new Vector(_x / norm, _y / norm, _z /norm);
    }

    public double getx() {
        return _x;
    }

    public double gety() {
        return _y;
    }

    public double getz() {
        return _z;
    }
}
