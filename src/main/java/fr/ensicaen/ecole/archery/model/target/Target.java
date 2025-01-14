package fr.ensicaen.ecole.archery.model.target;

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
import fr.ensicaen.ecole.archery.model.space.Element3D;
import fr.ensicaen.ecole.archery.model.space.Point;

/**
 * This is a Simple Target, divided in sections
 */
public interface Target extends Element3D {

    int computesPoint(Projectile projectile);

    int getNumberOfSections();

    double getRadius();

    Point getPosition();

}
