package fr.ensicaen.ecole.archery;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.*;

public class GameController {

    public GameController() {
        Target target = new CircleTarget(new Point(200, 200), 10, 300);
        Shooter shooter = new Shooter(
                target, new Bow(new Point(200, 40)), 500
        );
        Player player = new Human(shooter);

    }

}
