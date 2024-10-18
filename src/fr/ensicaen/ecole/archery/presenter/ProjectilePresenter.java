package fr.ensicaen.ecole.archery.presenter;

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
    public void update() {

    }

    @Override
    public void draw() {

    }
}
