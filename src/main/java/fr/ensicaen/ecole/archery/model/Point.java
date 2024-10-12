package fr.ensicaen.ecole.archery.model;

public class Point {
    public double x;
    public double y;
    public double z;

    public Point(double X, double Y){
        x = X;
        y = Y;
        z = 0;
    }

    public Point(double X, double Y, double Z){
        x = X;
        y = Y;
        z = Z;
    }
}
