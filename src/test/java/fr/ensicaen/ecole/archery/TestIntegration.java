package fr.ensicaen.ecole.archery;

import fr.ensicaen.ecole.archery.model.Domain;
import fr.ensicaen.ecole.archery.presenter.BuilderDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegration {

    private BuilderDomain _builderDomain;

    @Test
    public void test_number_of_arrows_drop() {
        _builderDomain = new BuilderDomain();
        _builderDomain.buildNumberOfArrow(5);
        Domain _domain = _builderDomain.build();

        assertEquals(5, _domain.shooter.getNumberOfProjectiles());
        _domain.player.play();
        assertEquals(5, _domain.shooter.getNumberOfProjectiles());
        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.player.play();
        assertEquals(4, _domain.shooter.getNumberOfProjectiles());
    }

    @Test
    public void test_do_not_shoot_when_no_arrow() {
        _builderDomain = new BuilderDomain();
        _builderDomain.buildNumberOfArrow(1);
        Domain _domain = _builderDomain.build();

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.player.play();
        assertEquals(0, _domain.shooter.getNumberOfProjectiles());
        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.player.play();
        assertEquals(0, _domain.shooter.getNumberOfProjectiles());
    }

    @Test
    public void test_score_at_different_power() {
        _builderDomain = new BuilderDomain();
        _builderDomain.buildNumberOfArrow(20);
        _builderDomain.buildTargetDistance(4);
        Domain _domain = _builderDomain.build();

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.player.play();
        assertEquals(0, _domain.shooter.getScore());
        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.defaultBow.setAngleY(Math.PI / 4);
        _domain.player.play();
        assertEquals(0, _domain.shooter.getScore());

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.defaultBow.setAngleY(Math.PI / 4 - 0.1);
        _domain.player.play();
        assertEquals(4, _domain.shooter.getScore());

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.defaultBow.setAngleY(Math.PI / 4 - 0.3);
        _domain.player.play();
        assertEquals(13, _domain.shooter.getScore());

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.defaultBow.setAngleY(Math.PI / 4 - 0.3);
        _domain.defaultBow.setAngleX(-0.2);
        _domain.player.play();
        assertEquals(15, _domain.shooter.getScore());

        _domain.defaultBow.setPower(_domain.defaultBow.getMaxPower());
        _domain.defaultBow.setAngleY(Math.PI / 4 - 0.3);
        _domain.defaultBow.setAngleX(0.2);
        _domain.player.play();
        assertEquals(17, _domain.shooter.getScore());
    }

}
