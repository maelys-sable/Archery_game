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

import fr.ensicaen.ecole.archery.view.component.*;

/**
 * The FXML Interface Controller of the game
 * It also have the role of a mini factory to create View with graphical components
 */
public interface IGameController {

    double getWidth();

    double getHeight();

    BuilderDomain getBuilderDomain();

    void setBuilderDomain(BuilderDomain builderDomain);

    BowView createBowView(String bowTypeString);

    TargetView createTargetView();

    ProjectileView createProjectileView();

    ShooterView createShooterView();

    void launchGamePresenter();

}
