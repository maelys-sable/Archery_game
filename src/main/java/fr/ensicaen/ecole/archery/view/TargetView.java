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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class TargetView {

    private final Pane _area;

    public TargetView(Pane area) {
        _area = area;
    }

    public void drawCircle(Point position, double radius, boolean whiteColor, boolean withStroke) {
        Circle circle = new Circle();
        Color color = whiteColor ? Color.WHITE : Color.RED;
        circle.setCenterX(position.x);
        circle.setCenterY(position.y);
        circle.setRadius(radius);
        circle.setFill(color);
        circle.toBack();
        if (withStroke) {
            circle.setStroke(Color.BLACK);
            circle.setStrokeWidth(2);
        }
        _area.getChildren().add(circle);
    }

}
