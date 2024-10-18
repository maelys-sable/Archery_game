package fr.ensicaen.ecole.archery.view.component;

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

import javafx.scene.shape.Rectangle;

/**
 * This is the visual representation of a bow
 * This class is a concept since they are differents type of bow
 */
public abstract class BowView {

    private final Image[] _bowImages;
    private final ImageView _image;
    private final Pane _area;
    private final Pane _powerArea;
    private final Rectangle _powerBar = new Rectangle();
    private final double _width = 200;
    private final double _height = 200;

    public BowView(AnchorPane area, Pane powerArea, Image... bowImages) {
        _bowImages = bowImages;
        _image = new ImageView();
        _image.setFitWidth(_width);
        _image.setFitHeight(_height);
        _powerArea = powerArea;
        _area = area;
        _area.getChildren().add(_image);
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
    public void kill() {
        _area.getChildren().remove(_image);
        _area.getChildren().remove(_powerBar);
    }
    public Pane getPowerArea() {
        return _powerArea;
    }

    public int getNbImages() {
        return _bowImages.length;
    }

    public void drawBow(Point position, double rotationAngle, int index) {
        _image.setImage(_bowImages[index]);
        _image.setX(position.x);
        _image.setY(position.y);
        _image.setRotate(rotationAngle);
    }

    public void drawPower(double x, double y, double width, double height) {
        _powerBar.setX(x);
        _powerBar.setWidth(width);
        _powerBar.setY(y);
        _powerBar.setHeight(height);
        _powerBar.setFill(Color.RED);
    }

}
