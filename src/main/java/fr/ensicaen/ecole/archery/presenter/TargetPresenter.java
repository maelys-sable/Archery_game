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

    public TargetPresenter(GamePresenter presenter, Target target, TargetView targetView) {
        _presenter = presenter;
        _target = target;
        _targetView = targetView;
    }

    public void updateView() {
        Point position = _target.getPosition();
        double xScaled = position.x * _presenter.getScaleFieldToScreenRatio();
        double yScaled = position.y * _presenter.getScaleFieldToScreenRatio();
        double radiusScaled = _target.getRadius() * _presenter.getScaleFieldToScreenRatio();

        yScaled = _targetView.getMaxY() + 2 * yScaled / position.z;
        radiusScaled =  2 * radiusScaled / position.z;

        Point renderPosition = new Point(xScaled, yScaled);
        _targetView.draw(renderPosition, radiusScaled, _target.getNumberOfSections());
    }

}
