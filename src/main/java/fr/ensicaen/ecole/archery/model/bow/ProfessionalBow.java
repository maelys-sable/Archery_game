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

public class ProfessionalBow extends Bow {

    private static final double MAX_POWER = 8;
    private static final double POWER_INCREMENT_SCALE = 0.1;
    private static final double ERRATIC_MOVEMENT_RANGE = 2;

    public ProfessionalBow(Point position) {
        super(position, MAX_POWER, POWER_INCREMENT_SCALE, ERRATIC_MOVEMENT_RANGE);
    }

}

