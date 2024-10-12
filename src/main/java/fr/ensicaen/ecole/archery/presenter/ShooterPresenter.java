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
import fr.ensicaen.ecole.archery.model.Shooter;

public class ShooterPresenter implements Presenter {

    private final Shooter _shooter;
    private final ShooterView _shooterView;

    public ShooterPresenter(Shooter shooter, ShooterView shooterView) {
        _shooter = shooter;
        _shooterView = shooterView;
    }

    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {
        _shooterView.draw(_shooter.getScore());
    }

}
