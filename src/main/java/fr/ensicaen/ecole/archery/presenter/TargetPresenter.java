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

public class TargetPresenter {

    private final GamePresenter _presenter;
    private final Target _target;
    private final TargetView _targetView;
    private final TransformationSpace _transformationSpace;

    public TargetPresenter(GamePresenter presenter, TransformationSpace transformationSpace, Target target, TargetView targetView) {
        _transformationSpace = transformationSpace;
        _presenter = presenter;
        _target = target;
        _targetView = targetView;
    }

    public void updateView() {
        Point position = _transformationSpace.transformModelPositionToViewPosition(_target.getPosition());
        double radiusScaled = _transformationSpace.transformRadius(_target.getPosition(), _target.getRadius());
        _targetView.draw(position, 20, _target.getNumberOfSections());
    }

}
