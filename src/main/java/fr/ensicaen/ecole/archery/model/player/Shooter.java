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


/**
 * This is the class for the shooter representation
 * The Shooter can only shoot arrows and count its score
 */
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

    public void reset() {
        _score = 0;
        _numberOfProjectiles = _initialNumberOfProjectiles;
    }

    /**
     * Create the projectile played if it cans
     * @return the projectile played
     */
    public Projectile shoot() {
        if (_numberOfProjectiles == 0 || _bow.getPower() <= _bow.getMinPower()) {
            _bow.setPower(0);
            return null;
        }
        Projectile projectile = _bow.createProjectile();
        countPoints(projectile);
        _bow.setPower(0);
        _numberOfProjectiles --;
        return projectile;
    }

    private void countPoints(Projectile projectile) {
        _score += _target.computesPoint(projectile);
    }

}