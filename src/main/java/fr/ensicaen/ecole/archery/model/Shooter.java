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

public class Shooter {

    private final Target _target;
    private final Weapon _weapon;
    private int _numberOfProjectiles;
    private int _score = 0;

    public Shooter(Target target, Weapon weapon, int numberOfProjectiles) {
        _target = target;
        _weapon = weapon;
        _numberOfProjectiles = numberOfProjectiles;
    }

    public Projectile shoot() {
        if (_numberOfProjectiles == 0) {
            _weapon.setPower(0);
            return _weapon.createProjectile();
        }
        Projectile projectile = _weapon.createProjectile();
        _score += _target.computesPoint(projectile);
        _weapon.setPower(0);
        _numberOfProjectiles --;
        return projectile;
    }

    public int getScore() {
        return _score;
    }

    public int getNumberOfProjectiles() {
        return _numberOfProjectiles;
    }

}