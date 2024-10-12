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

public class TargetPresenter {

    private final Target _target;
    private final TargetView _targetView;

    public TargetPresenter(Target target, TargetView targetView) {
        _target = target;
        _targetView = targetView;
    }

    public void updateView() {
        Point position =_target.getPosition();
        double renderY = _targetView.getMaxY() + position.y / (position.z + 1);
        Point renderPosition = new Point(position.x, renderY);
        int renderRadius =  _target.getRadius() / (int) (Math.log(position.z) + 1);
        _targetView.draw(renderPosition, renderRadius, _target.getNumberOfSections());
    }

}
