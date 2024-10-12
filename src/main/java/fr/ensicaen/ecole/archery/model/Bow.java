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

    private final double MAX_POWER = 200;
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

    public double getMaxPower() {
        return MAX_POWER;
    }

    public double getPower() {
        return _power;
    }

    @Override
    public void increasePower(double deltaPower) {
        _power += deltaPower;
        if (_power > MAX_POWER) {
            _power = MAX_POWER;
        }
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

    @Override
    public void setPower(double power) {
        _power = power;
    }

}