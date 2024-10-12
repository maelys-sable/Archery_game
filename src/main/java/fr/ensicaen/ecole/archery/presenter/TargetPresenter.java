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

public class TargetPresenter implements Presenter {

    private final Target _target;
    private final TargetView _targetView;

    public TargetPresenter(Target target, TargetView targetView) {
        _target = target;
        _targetView = targetView;
    }

    @Override
    public void updateModel() {

    }

    @Override
    public void drawView() {
        Point position =_target.getPosition();
        Point renderPosition = new Point(position.x, position.y);
        _targetView.draw(renderPosition, _target.getRadius(), _target.getNumberOfSections());
    }

}
