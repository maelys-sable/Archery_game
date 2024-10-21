package fr.ensicaen.ecole.archery.view.component;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * The view of a shooter
 * It includes score and number of projectiles
 */
public class ShooterView {

    private final Label _arrowLabel;
    private final Label _scoreLabel;

    public ShooterView(Label arrowLabel, Label scoreLabel) {
        _arrowLabel = arrowLabel;
        _scoreLabel = scoreLabel;
    }

    public void drawNbArrow(Integer nbArrow) {
        _arrowLabel.setText(nbArrow.toString());
    }

    public void drawScore(Integer score) {
        final int scoreWidth = 110;
        _scoreLabel.setText(score.toString());
        _scoreLabel.setAlignment(Pos.CENTER_RIGHT);
        _scoreLabel.setPrefWidth(scoreWidth);
    }

}
