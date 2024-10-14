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

public interface Weapon extends Element3D {

    void increasePower(double scalePower);

    double getPower();

    double getMaxPower();

    void setAngleX(double angleX);

    void setAngleY(double angleY);

    Projectile createProjectile();

    void setPower(double power);
}
