package fr.ensicaen.ecole.archery.model.space;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

/**
 * Functional interface for Elements in a 3D plan which have a position
 * It is used to prevent readers of which Elements in our domain are static
 * in this 3D plan
 */
@FunctionalInterface
public interface Element3D {
    Point getPosition();
}
