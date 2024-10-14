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

public interface Projectile {

    Point getPosition(double depth);

    double getFinalDistance();

    void setFinalDistance(double finalDistance);

}
