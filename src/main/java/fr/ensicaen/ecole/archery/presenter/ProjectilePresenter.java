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

import fr.ensicaen.ecole.archery.view.ProjectileView;
import fr.ensicaen.ecole.archery.model.Projectile;

public class ProjectilePresenter implements Presenter {

    private Projectile _projectile;
    private ProjectileView _projectileView;

    public ProjectilePresenter(Projectile projectile, ProjectileView projectileView) {
        _projectile = projectile;
        _projectileView = projectileView;
    }


    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {

    }

}
