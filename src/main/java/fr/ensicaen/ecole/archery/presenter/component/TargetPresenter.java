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

import fr.ensicaen.ecole.archery.model.target.Target;
import fr.ensicaen.ecole.archery.model.space.Point;
import fr.ensicaen.ecole.archery.view.component.TargetView;


/**
 * Class for mediation between the view of the target and the object
 */
public class TargetPresenter {

    private final Target _target;
    private final TargetView _targetView;
    private final AdapterTransformationSpace _adapterTransformationSpace;

    public TargetPresenter(AdapterTransformationSpace adapterTransformationSpace, Target target, TargetView targetView) {
        _adapterTransformationSpace = adapterTransformationSpace;
        _target = target;
        _targetView = targetView;
        createView();
    }

    private void createView() {
        Point position = _adapterTransformationSpace.project3DPointTo2D(_target.getPosition());
        double radiusScaled = _adapterTransformationSpace.transformRadius(_target.getPosition(), _target.getRadius());
        for (int i = _target.getNumberOfSections(); i > 0; i --) {
            double radiusAdjusted = radiusScaled / _target.getNumberOfSections() * i;
            _targetView.drawCircle(position, radiusAdjusted, i % 2 == 0, i == _target.getNumberOfSections());
        }
    }
    public Point getTargetPosition() {
        return _target.getPosition();
    }

    public double getTargetRadius() {
        return _target.getRadius();
    }
}
