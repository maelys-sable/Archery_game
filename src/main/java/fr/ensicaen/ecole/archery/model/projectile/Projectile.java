package fr.ensicaen.ecole.archery.model.projectile;

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
 * Default behaviour of a projectile
 */
public interface Projectile {

    public double getPower();

    Point computePositionFromDistance(double distance);

    double distanceWhereProjectileStopped();

    void setDistanceWhereProjectileHitTarget(double finalDistance);

}
