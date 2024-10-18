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


/**
 * The presenter of the Main Title
 * In the main title, You can only manipulate game options
 */
public class MainTitlePresenter {

    public void createGame(IGameController gameController, int numberOfArrows, int targetDistance) {
        BuilderDomain builderDomain = new BuilderDomain();
        builderDomain.buildNumberOfArrow(numberOfArrows);
        builderDomain.buildTargetDistance(targetDistance);
        gameController.setBuilderDomain(builderDomain);
        gameController.launchGamePresenter();
    }

}