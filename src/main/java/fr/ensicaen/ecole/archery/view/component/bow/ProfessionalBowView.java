package fr.ensicaen.ecole.archery.view.component.bow;

import fr.ensicaen.ecole.archery.view.component.BowView;
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

public class ProfessionalBowView extends BowView {

    public ProfessionalBowView(AnchorPane area, Pane powerArea) {
        super(area, powerArea,
                new Image(String.valueOf(ProfessionalBowView.class.getResource("ProfessionalBow1.png"))),
                new Image(String.valueOf(ProfessionalBowView.class.getResource("ProfessionalBow2.png"))),
                new Image(String.valueOf(ProfessionalBowView.class.getResource("ProfessionalBow3.png"))),
                new Image(String.valueOf(ProfessionalBowView.class.getResource("ProfessionalBow4.png")))
        );
    }

}
