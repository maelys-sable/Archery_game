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

import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.space.TransformationSpace;
import fr.ensicaen.ecole.archery.view.ProjectileView;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ProjectilePresenter {

    private static final double _scaleDepth = 0.1;
    private final Projectile _projectile;
    private final ProjectileView _projectileView;
    private final TransformationSpace _transformationSpace;
    private double _depth = 0;
    private final double _radius = 0.3;

    public ProjectilePresenter(TransformationSpace transformationSpace, Projectile projectile, ProjectileView projectileView) {
        _projectile = projectile;
        _projectileView = projectileView;
        _transformationSpace = transformationSpace;
    }

    public void updateView() {

        _depth += _scaleDepth * _projectile.getFinalDistance();
        if (_depth > _projectile.getFinalDistance()) {
            _depth = _projectile.getFinalDistance();
        }

        Point position = _projectile.computePositionFromDepth(_depth);
        position.z = _depth;
        Point positionRender = _transformationSpace.transformModelPositionToViewPosition(position);
        double renderRadius = _transformationSpace.transformRadius(position, _radius);
        Point position1 = _projectile.computePositionFromDepth(_depth);
        Point position2 = _projectile.computePositionFromDepth(_depth + _scaleDepth * _projectile.getFinalDistance());
        double angle = _transformationSpace.computeAngleRotation(position1, position2);

        positionRender = _transformationSpace.translatePointInCircleOnTopCornerSquare(positionRender, renderRadius, Math.toRadians(angle));
        _projectileView.drawProjectile(positionRender, angle, renderRadius);
    }



    public boolean hasReachedDestination() {
        return _depth >= _projectile.getFinalDistance();
    }

    /* Animation Projectile disappears */
    public void kill() {
        Timeline killTimeline = new Timeline(new KeyFrame(Duration.millis(3000), i -> {
            _projectileView.kill();
        }));
        killTimeline.setCycleCount(1);
        killTimeline.play();
    }

}
