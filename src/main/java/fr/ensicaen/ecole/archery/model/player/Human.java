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

import fr.ensicaen.ecole.archery.model.projectile.Projectile;


/**
 * This is a real Human
 */
public class Human implements Player {

    private final Shooter _shooter;

    public Human(Shooter shooter) {
        _shooter = shooter;
    }

    @Override
    public Projectile play() {
        return _shooter.shoot();
    }

}