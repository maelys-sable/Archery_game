package fr.ensicaen.ecole.archery.presenter.component;

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
import fr.ensicaen.ecole.archery.view.component.ProjectileView;
import fr.ensicaen.ecole.archery.model.projectile.Projectile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Class for mediation between the view of the projectile and the object
 */
public class ProjectilePresenter {

    private final Projectile _projectile;
    private final ProjectileView _projectileView;
    private final AdapterTransformationSpace _adapterTransformationSpace;
    private final double _scaleDepth;
    private double _depth = 0;

    public ProjectilePresenter(AdapterTransformationSpace adapterTransformationSpace, Projectile projectile, ProjectileView projectileView) {
        _scaleDepth = 0.02 * projectile.getPower();
        _projectile = projectile;
        _projectileView = projectileView;
        _adapterTransformationSpace = adapterTransformationSpace;
    }

    public void updateView() {
        final double radius = 0.3;
        moveProjectile();
        Point position = _projectile.computePositionFromDistance(_depth);
        position.z = _depth;
        Point positionRender = _adapterTransformationSpace.project3DPointTo2D(position);
        double renderRadius = _adapterTransformationSpace.transformRadius(position, radius);
        Point position1 = _projectile.computePositionFromDistance(_depth);
        Point position2 = _projectile.computePositionFromDistance(_depth + _scaleDepth * _projectile.distanceWhereProjectileStopped());
        double angle = _adapterTransformationSpace.computeAngleRotationBetweenTwoPoints(position1, position2);
        positionRender = _adapterTransformationSpace.translatePointInCircleOnTopCornerSquare(positionRender, renderRadius, Math.toRadians(angle));
        _projectileView.drawProjectile(positionRender, angle, renderRadius);

    }

    public boolean hasReachedDestination() {
        return _depth >= _projectile.distanceWhereProjectileStopped();
    }

    /* Animation Projectile disappears */
    public void kill() {
        final double timeOfTheProjectileBeforeDisappears = 3000;
        Timeline killTimeline = new Timeline(
                new KeyFrame(
                        Duration.millis(timeOfTheProjectileBeforeDisappears),
                        i -> _projectileView.kill()
                )
        );
        killTimeline.setCycleCount(1);
        killTimeline.play();
    }

    public void killInstant() {
        _projectileView.kill();
    }

    public double getDepth() {
        return _depth;
    }

    private void moveProjectile() {
        _depth += _scaleDepth * _projectile.distanceWhereProjectileStopped();
        if (_depth > _projectile.distanceWhereProjectileStopped()) {
            _depth = _projectile.distanceWhereProjectileStopped();
        }
    }
}
