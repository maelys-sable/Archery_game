package fr.ensicaen.ecole.archery.model;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


import java.awt.Point;


public interface Target {

    public int computesPoint(Projectile projectile);

    public int getNumberOfSections();

    public int getRadius();

    public int getDistance();

    public Point getPosition();

}
