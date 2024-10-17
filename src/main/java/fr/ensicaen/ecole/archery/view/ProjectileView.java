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

import fr.ensicaen.ecole.archery.model.space.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The view of a projectile
 */
public class ProjectileView {

    private final Pane _area;
    private final ImageView _imageProjectile = new ImageView();
    private boolean _init = false;

    public ProjectileView(Pane area) {
        _area = area;
        _imageProjectile.setImage(new Image(getClass().getResource("arrow.png").toExternalForm()));
    }

    public void drawProjectile(Point position, double angle, double radius) {
        _imageProjectile.setFitWidth(radius);
        _imageProjectile.setFitHeight(radius);
        _imageProjectile.setLayoutX(position.x);
        _imageProjectile.setLayoutY(position.y);
        _imageProjectile.setRotate(angle);
        /* If we add the image at the creation of the object,
        it will appear in (0, 0) in a brief instant */
        if (!_init) {
            _area.getChildren().add(_imageProjectile);
            _init = true;
        }
    }

    public void kill() {
        _area.getChildren().remove(_imageProjectile);
    }

}
