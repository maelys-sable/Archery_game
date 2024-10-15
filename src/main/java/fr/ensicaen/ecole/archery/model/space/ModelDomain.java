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

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.bow.BowFactory;

import static fr.ensicaen.ecole.archery.model.bow.BowFactory.BowType.*;

import fr.ensicaen.ecole.archery.model.player.Human;
import fr.ensicaen.ecole.archery.model.player.Player;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.target.CircleTarget;
import fr.ensicaen.ecole.archery.model.target.Target;

public class ModelDomain {

    private static final double WIDTH_SPACE = 3;

    private static final Point TARGET_POSITION = new Point(1.5, 1, 5);
    private static final int TARGET_NUMBER_OF_SECTIONS = 10;
    private static final double TARGET_RADIUS = 1;

    private static final Point BOW_POSITION = new Point(1.5, 0, 1.2);

    private static int _numberOfArrow = 0;
    private Bow _bow;
    private Player _player;
    private Target _target;
    private Shooter _shooter;

    public ModelDomain() {
    }

    public void createModelDomain() {
        _target = new CircleTarget(TARGET_POSITION, TARGET_NUMBER_OF_SECTIONS, TARGET_RADIUS);
        _bow = new BowFactory().createBow(DEFAULT_BOW, BOW_POSITION);
        _shooter = new Shooter(_target, _bow, _numberOfArrow);
        _player = new Human(_shooter);

    }

    public void setNumberOfArrow(int numberOfArrow) {
        _numberOfArrow = numberOfArrow;
    }

    public double getWidthSpace() {
        return WIDTH_SPACE;
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
