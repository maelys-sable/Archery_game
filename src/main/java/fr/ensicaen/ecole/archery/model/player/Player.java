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
 * This is a Player, its role is for the moment, only to play
 * Maybe later, it would buy
 */
@FunctionalInterface
public interface Player {

    /**
     * Score its throw
     * @return the projectile played
     */
    Projectile play();

}