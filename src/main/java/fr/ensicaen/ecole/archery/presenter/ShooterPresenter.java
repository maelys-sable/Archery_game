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

import fr.ensicaen.ecole.archery.view.ShooterView;
import fr.ensicaen.ecole.archery.model.player.Shooter;

public class ShooterPresenter {

    private final Shooter _shooter;
    private final ShooterView _shooterView;

    public ShooterPresenter(Shooter shooter, ShooterView shooterView) {
        _shooter = shooter;
        _shooterView = shooterView;
    }

    public void updateView() {
        _shooterView.drawNbArrow(_shooter.getNumberOfProjectiles());
        _shooterView.drawScore(_shooter.getScore());
    }
    public void resetView(){
        _shooter.reset();
        updateView();
    }
}
