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

public class ModelDomain {

    private final Weapon _weapon;
    private final Player _player;
    private final Target _target;
    private final Shooter _shooter;

    public ModelDomain() {
        _target = new CircleTarget(new Point(1.5, 1, 5), 10, 1);
        _weapon = new Bow(new Point(1.5, 0, 1.2));
        _shooter = new Shooter(_target, _weapon, 100);
        _player = new Human(_shooter);
    }

    public Target getTarget() {
        return _target;
    }

    public Player getPlayer() {
        return _player;
    }

    public Shooter getShooter() {
        return _shooter;
    }

    public Weapon getWeapon() {
        return _weapon;
    }

}
