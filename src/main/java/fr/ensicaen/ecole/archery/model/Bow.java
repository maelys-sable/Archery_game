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


 public class Bow implements Weapon {

    private double _power = 0;
    private double _angleX = 0;
    private double _angleY = 0;
    private final Point _position;

    public Bow(Point position) {
        _position = position;
    }

    public Point getPosition() {
        return _position;
    }
    
    public void setPower(double power) {
        _power = power ;
    }

    public void setAngleX(double angleX) {
        _angleX = angleX ;
    }

    public void setAngleY(double angleY) {
        _angleY = angleY ;
    }

    public Projectile createProjectile() {
        return new Arrow(_position, _angleX, _angleY, _power);
    }

 }