package fr.ensicaen.ecole.archery.view.bow;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import fr.ensicaen.ecole.archery.presenter.BowPresenter;
import javafx.scene.shape.Rectangle;


public class BowView {

    private final ImageView _BowView;
    private final AnchorPane _mainArea;
    private final Pane _powerArea;
    private final Rectangle _powerBar = new Rectangle();
    private final double _width = 100;
    private final double _height = 200;

    public BowView(AnchorPane area, Pane powerArea, String filename) {
        Image bowImage = new Image(getClass().getResource(filename).toExternalForm());
        _BowView = new ImageView(bowImage);
        _BowView.setFitWidth(_width);
        _BowView.setFitHeight(_height);
        _mainArea = area;
        _powerArea = powerArea;
        _mainArea.getChildren().add(_BowView);
        _powerArea.getChildren().add(_powerBar);
        createPowerStroke();
    }

    public double getWidth() {
        return _width;
    }

    public double getHeight() {
        return _height;
    }

    /**
     * Border of the Power Bar
     */
    private void createPowerStroke() {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setWidth(_powerArea.getPrefWidth());
        rectangle.setY(0);
        rectangle.setHeight(_powerArea.getPrefHeight());
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(4);
        _powerArea.getChildren().add(rectangle);
    }

    public Pane getArea() {
        return _mainArea;
    }

    public Pane getPowerArea() {
        return _powerArea;
    }

    public void drawBow(Point position, double rotationAngle) {
        _BowView.setX(position.x);
        _BowView.setY(position.y);
        _BowView.setRotate(rotationAngle);
    }

    public void drawPower(double x, double y, double width, double height) {
        _powerBar.setX(x);
        _powerBar.setWidth(width);
        _powerBar.setY(y);
        _powerBar.setHeight(height);
        _powerBar.setFill(Color.RED);
    }

}
