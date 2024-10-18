package fr.ensicaen.ecole.archery.presenter;

import fr.ensicaen.ecole.archery.view.ShooterView;
import fr.ensicaen.ecole.archery.model.Shooter;

public class ShooterPresenter implements Presenter {
    private final Shooter _shooter;
    private final ShooterView _shooterView;

    public ShooterPresenter(Shooter shooter, ShooterView shooterView) {
        _shooter = shooter;
        _shooterView = shooterView;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        _shooterView.drawShooter(_shooter.getScore());
    }
}
