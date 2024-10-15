package fr.ensicaen.ecole.archery.model.player;


/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.target.Target;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;

public class Shooter {

    private final Target _target;
    private final int _initialNumberOfProjectiles;
    private int _numberOfProjectiles;
    private Bow _bow;
    private int _score = 0;

    public Shooter(Target target, Bow bow, int numberOfProjectiles) {
        _target = target;
        _bow = bow;
        _numberOfProjectiles = numberOfProjectiles;
        _initialNumberOfProjectiles = numberOfProjectiles;
    }

    public int getScore() {
        return _score;
    }

    public int getNumberOfProjectiles() {
        return _numberOfProjectiles;
    }

    public void setBow(Bow bow) {
        _bow = bow;
    }

    public Projectile shoot() {
        if (_numberOfProjectiles == 0 || _bow.getPower() <= _bow.getMinPower()) {
            _bow.setPower(0);
            return null;
        }
        Projectile projectile = _bow.createProjectile();
        _score += _target.computesPoint(projectile);
        _bow.setPower(0);
        _numberOfProjectiles --;
        return projectile;
    }

    public void reset() {
        _score = 0;
        _numberOfProjectiles = _initialNumberOfProjectiles;
    }

}