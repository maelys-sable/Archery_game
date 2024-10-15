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
import fr.ensicaen.ecole.archery.model.bow.BowFactory;
import fr.ensicaen.ecole.archery.model.player.Human;
import fr.ensicaen.ecole.archery.model.player.Player;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.target.CircleTarget;
import fr.ensicaen.ecole.archery.model.target.Target;

import static fr.ensicaen.ecole.archery.model.bow.BowFactory.BowType.DEFAULT_BOW;

public class BuilderDomain {

    private final double _widthSpace = 3;
    private final Point _targetPosition = new Point(1.5, 1, 5);
    private final int _targetNumberOfSections = 10;
    private final double _targetRadius = 1;
    private final Point _bowPosition = new Point(1.5, 0, 1.2);
    private int _numberOfArrow = 0;

    public BuilderDomain() {
    }

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
