/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

 package fr.ensicaen.ecole.archery.model;

 public class Bow implements Weapon {

    private double _power;
    private double _angleX;
    private double _angleY;
    
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
        return new Arrow(_angleX,_angleY, _power);
    }
 }