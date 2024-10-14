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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import fr.ensicaen.ecole.archery.presenter.WeaponPresenter;
import javafx.scene.shape.Rectangle;


public class WeaponView {

    private final ImageView _BowView;
    private final AnchorPane _area;
    private final Pane _powerArea;
    private final Rectangle _rectanglePower = new Rectangle();
    private WeaponPresenter _weaponPresenter;

    public WeaponView(AnchorPane area, Pane powerArea) {
        Image bowImage = new Image("fr/ensicaen/ecole/archery/bow.png");
        _BowView = new ImageView(bowImage);
        _BowView.setFitWidth(100);
        _BowView.setFitHeight(200);
        _area = area;
        _powerArea = powerArea;
        _area.getChildren().add(_BowView);
        _powerArea.getChildren().add(_rectanglePower);
        createPowerStroke();
    }

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
        return _area;
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
        _rectanglePower.setX(x);
        _rectanglePower.setWidth(width);
        _rectanglePower.setY(y);
        _rectanglePower.setHeight(height);
        _rectanglePower.setFill(Color.RED);
    }

}
