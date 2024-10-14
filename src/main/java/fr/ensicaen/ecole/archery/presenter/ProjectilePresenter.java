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

    public ProjectilePresenter(GamePresenter presenter, TransformationSpace transformationSpace, Projectile projectile, ProjectileView projectileView) {
        _projectile = projectile;
        _projectileView = projectileView;
        _presenter = presenter;
        _transformationSpace = transformationSpace;
    }

    public void updateView() {
        _depth += _scaleDepth * _projectile.getFinalDistance();

        Point position = _transformationSpace.transformModelPositionToViewPosition(_projectile.getPosition(_depth));
        System.out.println("depth : " + _depth);
        System.out.println("Reel position ; " + _projectile.getPosition(_depth));
        System.out.println("ProjectilePresenter: " + position);
        System.out.println("final distance : " + _projectile.getFinalDistance());
        _projectileView.drawProjectile(position);
    }

    public boolean hasReachedDestination() {
        return _depth >= _projectile.getFinalDistance();
//        return _depth - epsilon <= _projectile.getFinalDistance() && _depth + epsilon >= _projectile.getFinalDistance();
    }

    public void kill() {
        _projectileView.kill();
    }

}
