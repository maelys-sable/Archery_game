package fr.ensicaen.ecole.archery.presenter;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */

import fr.ensicaen.ecole.archery.model.Target;
import fr.ensicaen.ecole.archery.model.Point;
import fr.ensicaen.ecole.archery.view.TargetView;
import javafx.scene.layout.Pane;

public class TargetPresenter implements Presenter {

    private final Target _target;
    private final TargetView _targetView;
    private final Pane _targetArea;

    public TargetPresenter(Target target, TargetView targetView, Pane targetArea) {
        _target = target;
        _targetView = targetView;
        _targetArea = targetArea;
    }

    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {
        Point position =_target.getPosition();
        double renderY = _targetArea.getLayoutY() + position.y / (position.z + 1);
        Point renderPosition = new Point(position.x, renderY);
        int renderRadius =  _target.getRadius() / (int) (Math.log(position.z) + 1);
        _targetView.draw(renderPosition, renderRadius, _target.getNumberOfSections());
    }

}
