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

<<<<<<< HEAD
    double getPower();

    Point computePositionFromDistance(double distance);
=======
    Point getPosition(double depth);
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0

    double getFinalDistance();

    void setFinalDistance(double finalDistance);

}
