package fr.ensicaen.ecole.archery.model.bow;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


import fr.ensicaen.ecole.archery.model.projectile.Arrow;
import fr.ensicaen.ecole.archery.model.space.Element3D;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;

public abstract class Bow implements Element3D {

    private final double _maxPower;
<<<<<<< HEAD
    private final double _limitPower;
    private final double _powerIncrementRate;
    private final Point _position;
    private final double _erraticMovementRange;
    private double _power = 0;
    private double _angleX = 0;
    private double _angleY = 0;

    public Bow(Point position, double maxPower, double powerIncrementScale, double erraticMovementRange) {
        final double minimumHitTick = 2;
        _position = position;
        _maxPower = maxPower;
        _powerIncrementRate = powerIncrementScale;
        _limitPower = _powerIncrementRate * _maxPower * minimumHitTick;
        _erraticMovementRange = erraticMovementRange;
=======
    private final double _powerIncrementScale;
    private double _power = 0;
    private double _angleX = 0;
    private double _angleY = 0;
    private final Point _position;

    public Bow(Point position, double maxPower, double powerIncrementScale) {
        _position = position;
        _maxPower = maxPower;
        _powerIncrementScale = powerIncrementScale;
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

    @Override
    public Point getPosition() {
        return _position;
    }
    
    public double getErraticMovementRange() { 
		return _erraticMovementRange; 
    }

    public double getMaxPower() {
        return _maxPower;
    }

    public double getPower() {
        return _power;
    }

    public void increasePower() {
        _power += _powerIncrementScale * _maxPower;
        if (_power > _maxPower) {
            _power = _maxPower;
        }
    }

    public void setPower(double power) {
        _power = power;
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

