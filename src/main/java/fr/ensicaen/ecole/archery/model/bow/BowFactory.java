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

public class BowFactory {

    public enum BowType {
        DEFAULT_BOW;
    }

    public static Bow createBow(BowType type, Point position) {
        switch (type) {
            case DEFAULT_BOW:
                return new DefaultBow(position);
            default:
                throw new IllegalArgumentException("Unsupported bow type: " + type);
        }
    }

}
