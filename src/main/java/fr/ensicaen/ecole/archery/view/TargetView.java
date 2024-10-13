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
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class TargetView {

    private final Pane _area;
    private final Pane _targetArea;

    public TargetView(Pane area, Pane targetArea) {
        _area = area;
        _targetArea = targetArea;
    }

    public double getMaxY() {
        return _targetArea.getLayoutY();
    }

    public void draw(Point position, double radius, int numberOfSections) {
        for (int i = numberOfSections; i > 0; i --) {
            Color color = i % 2 == 0 ? Color.WHITE : Color.RED;
            double radiusAdjusted = radius / numberOfSections * i;
            Circle circle = createCircle(position, radiusAdjusted, color);
            if (i == numberOfSections) {
                circle.setStroke(Color.BLACK);
                circle.setStrokeWidth(2);
            }
            _area.getChildren().add(circle);
        }
    }

    private Circle createCircle(Point position, double radius, Color color) {
        Circle circle = new Circle();
        circle.setCenterX(position.x);
        circle.setCenterY(position.y);
        circle.setRadius(radius);
        circle.setFill(color);
        return circle;
    }

}
