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
<<<<<<< HEAD:src/main/java/fr/ensicaen/ecole/archery/view/component/ProjectileView.java

import java.util.Objects;

/**
 * The view of a projectile
 */
=======
>>>>>>> c84f47ec23fffa645a3ac59555ce2b68368801e0:src/main/java/fr/ensicaen/ecole/archery/view/ProjectileView.java
public class ProjectileView {

    private final Pane _area;
    private final ImageView _imageProjectile = new ImageView();
    private boolean _init = false;

    public ProjectileView(Pane area) {
        _area = area;
        _imageProjectile.setImage(new Image(Objects.requireNonNull(
                getClass().getResource("arrow.png")).toExternalForm()
        ));
    }

    public void drawProjectile(Point position, double angle, double radius) {
        _imageProjectile.setFitWidth(radius);
        _imageProjectile.setFitHeight(radius);
        _imageProjectile.setLayoutX(position.x);
        _imageProjectile.setLayoutY(position.y);
        _imageProjectile.setRotate(angle);
        if (!_init) {
            _area.getChildren().add(_imageProjectile);
            _init = true;
        }
    }

    public void kill() {
        _area.getChildren().remove(_imageProjectile);
    }

}
