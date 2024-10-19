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


import fr.ensicaen.ecole.archery.model.space.Point;


/**
 * This is the default bow object
 */
public class DefaultBow extends Bow {

    private static final double MAX_POWER = 4;
    private static final double POWER_INCREMENT_RATE = 0.05;
    private static final double OSCILLATION_AMPLITUDE = 9;

    public DefaultBow(Point position) {
        super(position, MAX_POWER, POWER_INCREMENT_RATE, OSCILLATION_AMPLITUDE);
    }

}
