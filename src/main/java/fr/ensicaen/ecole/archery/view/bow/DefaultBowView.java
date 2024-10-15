package fr.ensicaen.ecole.archery.view.bow;

import javafx.scene.image.Image;
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

    public DefaultBowView(AnchorPane area, Pane powerArea) {
        super(area, powerArea,
                new Image(String.valueOf(DefaultBowView.class.getResource("DefaultBow1.png"))),
                new Image(String.valueOf(DefaultBowView.class.getResource("DefaultBow2.png"))),
                new Image(String.valueOf(DefaultBowView.class.getResource("DefaultBow3.png"))),
                new Image(String.valueOf(DefaultBowView.class.getResource("DefaultBow4.png")))
        );
    }

}
