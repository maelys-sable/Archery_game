package fr.ensicaen.ecole.archery.view;

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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ProjectileView {

    private final Pane _area;
    private final Circle _projectile = new Circle();

    public ProjectileView(Pane area) {
        _area = area;
        _projectile.setFill(Color.BLACK);
        _projectile.setRadius(10);
        _area.getChildren().add(_projectile);
    }

    public void drawProjectile(Point position) {
        _projectile.setRadius(10 -position.z );
        _projectile.setLayoutX(position.x);
        _projectile.setLayoutY(position.y);
    }

}
