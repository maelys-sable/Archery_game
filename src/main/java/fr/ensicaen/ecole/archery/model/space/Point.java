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

import fr.ensicaen.ecole.archery.annotation.DataStructure;

/**
 * Data Struct of 3D Points
 */
@DataStructure
public class Point {

    public double x;
    public double y;
    public double z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(double x, double y){
        this(x, y, 0);
    }

}
