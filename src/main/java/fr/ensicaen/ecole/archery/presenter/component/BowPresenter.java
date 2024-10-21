package fr.ensicaen.ecole.archery.presenter.component;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.bow.Bow;
import fr.ensicaen.ecole.archery.model.player.Shooter;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.model.space.Vector;
import fr.ensicaen.ecole.archery.view.component.BowView;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

/**
 * Class for mediation between the view of the bow and the object
 */
public class BowPresenter {

    private final AdapterTransformationSpace _adapterTransformationSpace;
    private final double _animationTime = 30;
    private final Random random = new Random();
    private final Vector _deviation;
    private Timeline _bowAnimationTimeline;
    private Bow _bow;
    private BowView _bowView;
    private double _mouseX;
    private double _mouseY;
    private Point _oscillation;    
    
    public BowPresenter(AdapterTransformationSpace adapterTransformationSpace, Bow weapon, BowView bowView){
        _bow = weapon;
        _bowView = bowView;
        _oscillation = new Point(0, 0);
        _deviation = new Vector(0,0);
        _adapterTransformationSpace = adapterTransformationSpace;
        _bowAnimationTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            updateView();
            oscillate();
        }));
        _bowAnimationTimeline.setCycleCount(Animation.INDEFINITE);
        _bowAnimationTimeline.play();
    }

    public void changeBow(Shooter shooter, Bow newBow, BowView newBowView) {
        _deviation.setNull();
        _oscillation = new Point(0, 0);
        _bowView = newBowView;
        _bow = newBow;
        shooter.setBow(newBow);
        _bowAnimationTimeline = new Timeline(new KeyFrame(Duration.millis(_animationTime), i -> {
            updateView();
            oscillate();
        }));
        _bowAnimationTimeline.setCycleCount(Animation.INDEFINITE);
        _bowAnimationTimeline.play();
    }

    public void setMouseX(double mouseX) {
        _mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        _mouseY = mouseY;
    }

    public void increasePower() {
        _bow.increasePower();
    }

    public void updateView() {
        updateViewPower();
        final double adjustYPosition = 40;
        Point bowPosition = _adapterTransformationSpace.project3DPointTo2D(_bow.getPosition());
        bowPosition.x -= _bowView.getWidth() / 2;
        bowPosition.y -= _bowView.getHeight() / 2;
        Point angles = _adapterTransformationSpace.computeAngleXAndAngleYBetweenTwoPoints(
                bowPosition, getPointerPosition()
        );
        _bow.setAngleY(angles.y);
        _bow.setAngleX(angles.x);

        /* _bow.getPower() - 0.1 to ignore case index = nbImage */
        int index = (int) (_bowView.getNbImages() * (_bow.getPower() - 0.1) /_bow.getMaxPower());
        bowPosition.y -= adjustYPosition;
        _bowView.drawBow(bowPosition, Math.toDegrees(angles.z), index);
        _bowView.drawPointer(getPointerPosition());
    }

    public void killView() {
        _bowView.kill();
        _bowAnimationTimeline.stop();
    }

    private void updateViewPower() {
        double height = _bow.getPower() * _bowView.getPowerArea().getPrefHeight() / _bow.getMaxPower();
        double y = _bowView.getPowerArea().getPrefHeight() - height;
        double x = 0;
        _bowView.drawPower(x, y, _bowView.getPowerArea().getPrefWidth(), height);
    }

    private Point getPointerPosition() {
        return new Point(_mouseX + _oscillation.x, _mouseY + _oscillation.y);
    }

    private void oscillate() {
        double erraticMovementRange = _bow.getErraticMovementRange();
        double deviationX = (random.nextDouble() - 0.5) * erraticMovementRange;
        double deviationY = (random.nextDouble() - 0.5) * erraticMovementRange;
        _deviation.add(new Vector(deviationX, deviationY));
        lineariseMovement(erraticMovementRange);
        double maxBoundX = 20;
        double maxBoundY = 20;
        limitOscillation(maxBoundX, maxBoundY);
    }
    
    private void lineariseMovement(double erraticMovementRange) {
        final double inertia = 0.1;

        _oscillation.x += (_deviation.getX() - _oscillation.x) * inertia;
        _oscillation.y += (_deviation.getY() - _oscillation.y) * inertia;

        if (_oscillation.x > 0) {
            _oscillation.x -= erraticMovementRange * inertia;
        } else if (_oscillation.x < 0) {
            _oscillation.x += erraticMovementRange * inertia;
        }

        if (_oscillation.y > 0) {
            _oscillation.y -= erraticMovementRange * inertia;
        } else if (_oscillation.y < 0) {
            _oscillation.y += erraticMovementRange * inertia;
        }
    }

    private void limitOscillation(double maxBoundX, double maxBoundY) {
        if (_oscillation.x < -maxBoundX) {
            _oscillation.x = -maxBoundX + 1;
            _deviation.setX(0);
        } else if (_oscillation.x > maxBoundX) {
            _oscillation.x = maxBoundX - 1;
            _deviation.setX(0);
        }

        if (_oscillation.y < -maxBoundY) {
            _oscillation.y = -maxBoundY + 1;
            _deviation.setY(0);
        } else if (_oscillation.y > maxBoundY) {
            _oscillation.y = maxBoundY - 1;
            _deviation.setY(0);
        }
    }

}

