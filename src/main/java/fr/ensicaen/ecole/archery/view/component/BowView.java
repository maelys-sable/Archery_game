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
    private final Rectangle _powerBarStroke = new Rectangle();
    private final ImageView _pointer;
    private final double _width = 200;
    private final double _height = 200;
    private final double _pointerSize = 50;

    public BowView(AnchorPane area, Pane powerArea, Image... bowImages) {
        _bowImages = bowImages;
        _image = new ImageView();
        _pointer = new ImageView(
                new Image(String.valueOf(BowView.class.getResource("pointer.png")))
        );
        _pointer.setFitWidth(_pointerSize);
        _pointer.setFitHeight(_pointerSize);
        _image.setFitWidth(_width);
        _image.setFitHeight(_height);
        _powerArea = powerArea;
        _area = area;
        _area.getChildren().add(_image);
        _area.getChildren().add(_pointer);
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
        _powerBarStroke.setX(0);
        _powerBarStroke.setFill(Color.TRANSPARENT);
        _powerBarStroke.setWidth(_powerArea.getPrefWidth());
        _powerBarStroke.setY(0);
        _powerBarStroke.setHeight(_powerArea.getPrefHeight());
        _powerBarStroke.setStroke(Color.BLACK);
        _powerBarStroke.setStrokeWidth(4);
        _powerArea.getChildren().add(_powerBarStroke);
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

    public void drawPointer(Point position) {
        _pointer.setX(position.x - _pointerSize / 2);
        _pointer.setY(position.y - _pointerSize / 2);
    }

    public void drawPower(double x, double y, double width, double height) {
        _powerBar.setX(x);
        _powerBar.setWidth(width);
        _powerBar.setY(y);
        _powerBar.setHeight(height);
        _powerBar.setFill(Color.RED);
    }

    public void kill() {
        _area.getChildren().remove(_image);
        _powerArea.getChildren().remove(_powerBar);
        _powerArea.getChildren().remove(_powerBarStroke);
        _area.getChildren().remove(_pointer);
    }

}
