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
        Pane pane = new Pane();
        _area.getChildren().add(_projectile);
        _projectile.toFront();
    }

    public void drawProjectile(Point position, double radius) {
        _projectile.setRadius(radius);
        _projectile.setLayoutX(position.x);
        _projectile.setLayoutY(position.y);
    }

}
