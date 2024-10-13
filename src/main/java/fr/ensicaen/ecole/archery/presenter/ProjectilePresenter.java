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

import fr.ensicaen.ecole.archery.model.Point;
import fr.ensicaen.ecole.archery.view.ProjectileView;
import fr.ensicaen.ecole.archery.model.Projectile;

public class ProjectilePresenter {

    private static final double _scaleDepth = 0.05;
    private final Projectile _projectile;
    private final ProjectileView _projectileView;
    private final GamePresenter _presenter;
    private double _depth = 0;

    public ProjectilePresenter(GamePresenter presenter, Projectile projectile, ProjectileView projectileView) {
        _projectile = projectile;
        _projectileView = projectileView;
        _presenter = presenter;
    }

    public void updateView() {
        _depth += _scaleDepth * _projectile.getFinalDistance();
        Point position = _projectile.getPosition(_depth);
        double x = position.x * _presenter.getScaleFieldToScreenRatio();
        double y = position.y * _presenter.getScaleFieldToScreenRatio();
        _projectileView.drawProjectile(new Point(x, y, position.z));
    }

    public boolean hasReachedDestination() {
        return _depth == _projectile.getFinalDistance();
    }

}
