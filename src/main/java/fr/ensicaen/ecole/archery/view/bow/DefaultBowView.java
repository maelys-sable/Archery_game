package fr.ensicaen.ecole.archery.view.bow;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

public class DefaultBowView extends BowView {

    private static final String FILENAME = "bow.png";

    public DefaultBowView(AnchorPane area, Pane powerArea) {
        super(area, powerArea, FILENAME);
    }
}
