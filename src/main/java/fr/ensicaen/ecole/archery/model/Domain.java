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

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.player.Player;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.target.Target;

public class Domain {

    private final Player _player;
    private final Shooter _shooter;
    private final Bow _bow;
    private final Target _target;
    private final double _widthSpace;

    public Domain(Player player, Shooter shooter, Bow bow, Target target, double widthSpace) {
        _player = player;
        _shooter = shooter;
        _bow = bow;
        _target = target;
        _widthSpace = widthSpace;
    }

    public double getWidthSpace() {
        return _widthSpace;
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

    public Bow getBow() {
        return _bow;
    }

}
