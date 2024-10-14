package fr.ensicaen.ecole.archery.presenter;

import fr.ensicaen.ecole.archery.view.TargetView;
import fr.ensicaen.ecole.archery.model.Target;
import fr.ensicaen.ecole.archery.model.Point;

public class TargetPresenter implements Presenter {

    private final TargetView _targetView;
    public final Target _target;

     public TargetPresenter(TargetView targetView, Target target) {
         _targetView = targetView;
         _target = target;
     }

    @Override
    public void update() {

    }

    public static int changeRadiusWithPerspective(int radius, int distance) throws Exception{
        int res;
        try {
            res = radius/distance;
            return res;
        } catch (Exception e) {
            throw e;
        }
    }

    public static double changeYPositionWithPerspective(double y, int distance) throws Exception{
         double res;
         try {
             res = y/distance;
             return res;
         } catch (Exception e) {
             throw e;
         }
    }

    @Override
    public void draw() {
         int distance = _target.getDistance();
         Point position = _target.getPosition();
         int radius = _target.getRadius();
         int numberOfSections = _target.getNumberOfSections();

        radius = changeRadiusWithPerspective(radius, distance);
        Point viewPosition = new Point(position.getX(), changeYPositionWithPerspective(position.getY(), distance));

        _targetView.drawTarget(viewPosition, radius, numberOfSections);
    }
}
