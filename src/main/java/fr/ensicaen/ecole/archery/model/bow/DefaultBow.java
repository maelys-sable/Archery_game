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

public class DefaultBow extends Bow {

    private static final double MAX_POWER = 4;
<<<<<<< HEAD
    private static final double POWER_INCREMENT_RATE = 0.05;
    private static final double ERRATIC_MOVEMENT_RANGE = 5;

    public DefaultBow(Point position) {
        super(position, MAX_POWER, POWER_INCREMENT_RATE, ERRATIC_MOVEMENT_RANGE);
=======
    private static final double POWER_INCREMENT_SCALE = 0.05;

    public DefaultBow(Point position) {
        super(position, MAX_POWER, POWER_INCREMENT_SCALE);
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0
    }

}

