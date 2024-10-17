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
import fr.ensicaen.ecole.archery.model.player.Player;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.target.Target;

/**
 * A Structure for the model domain
 */
@DataStructure
public class Domain {

    public final Player player;
    public final Shooter shooter;
    public final Bow defaultBow;
    public final Bow professionalBow;
    public final Target target;
    public final double widthSpace;

    public Domain(Player player, Shooter shooter, Bow defaultBow, Bow professionalBow, Target target, double widthSpace) {
        this.player = player;
        this.shooter = shooter;
        this.defaultBow = defaultBow;
        this.professionalBow = professionalBow;
        this.target = target;
        this.widthSpace = widthSpace;
    }

}
