package fr.ensicaen.ecole.archery.presenter;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.Domain;
import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.bow.BowFactory;
import fr.ensicaen.ecole.archery.model.player.Human;
import fr.ensicaen.ecole.archery.model.player.Player;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.target.CircleTarget;
import fr.ensicaen.ecole.archery.model.target.Target;

import static fr.ensicaen.ecole.archery.model.bow.BowFactory.BowType.DEFAULT_BOW;

/**
 * This is a builder of all the domain
 * The User can modify parameters of the game, in fact, he is building his domain
 * For the moment, we can only interact with the number of arrows
 * In the future to add more parameters, we only have to create build layouts
 */
public class BuilderDomain {

    private final double _widthSpace = 3;
    private final Point _targetPosition = new Point(1.5, 1, 5);
    private final int _targetNumberOfSections = 10;
    private final double _targetRadius = 1;
    private final Point _bowPosition = new Point(1.5, 0, 1.2);
    private int _numberOfArrow = 0;

    public Domain build() {
        Target target = new CircleTarget(_targetPosition, _targetNumberOfSections, _targetRadius);
        Bow bow = new BowFactory().createBow(DEFAULT_BOW, _bowPosition);
        Shooter shooter = new Shooter(target, bow, _numberOfArrow);
        Player player = new Human(shooter);
        return new Domain(player, shooter, bow, target, _widthSpace);

    }

    public void buildNumberOfArrow(int numberOfArrow) {
        _numberOfArrow = numberOfArrow;
    }

}
