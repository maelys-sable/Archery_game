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

public class Human implements Player {

    private final Shooter _shooter;

    public Human(Shooter shooter) {
        _shooter = shooter;
    }

    public Projectile play() {
        return _shooter.shoot();
    }

}