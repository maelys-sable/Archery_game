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

    private static final double _scaleDepth = 0.1;
    private final Projectile _projectile;
    private final ProjectileView _projectileView;
    private final GamePresenter _presenter;
    private final TransformationSpace _transformationSpace;
    private double _depth = 0;
    private final double _radius = 0.02;

    public ProjectilePresenter(GamePresenter presenter, TransformationSpace transformationSpace, Projectile projectile, ProjectileView projectileView) {
        _projectile = projectile;
        _projectileView = projectileView;
        _presenter = presenter;
        _transformationSpace = transformationSpace;
    }

    public void updateView() {
        _depth += _scaleDepth * _projectile.getFinalDistance();
        if (_depth > _projectile.getFinalDistance()) {
            _depth = _projectile.getFinalDistance();
        }
        Point position = _projectile.getPosition(_depth);
        position.z = _depth;
        Point positionRender = _transformationSpace.transformModelPositionToViewPosition(position);
        double renderRadius = _transformationSpace.transformRadius(position, _radius);
        _projectileView.drawProjectile(positionRender, renderRadius);
    }

    public boolean hasReachedDestination() {
        return _depth == _projectile.getFinalDistance();
    }

    public void kill() {
        _projectileView.kill();
    }

}
