package fr.ensicaen.ecole.archery.presenter;

import fr.ensicaen.ecole.archery.view.ViewWeapon;
import fr.ensicaen.ecole.archery.model.Weapon;

public class WeaponPresenter implements Presenter {
    private final Weapon _weapon;
    private final WeaponView _weaponView;

    public WeaponPresenter (Weapon weapon, WeaponView weaponView){
        _weapon = weapon;
        _weaponView = weaponView;
    }


    @Override
    public void update() {

    }

    @Override
    public void draw() {
        double angleX = _weapon.getAngleX();
        double angleY = _weapon.getAngleY();
        double power = _weapon.getPower();
        _weaponView.drawWeapon(angleX, angleY, power);
    }
}
