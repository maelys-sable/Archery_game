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


import fr.ensicaen.ecole.archery.model.space.ModelDomain;
import fr.ensicaen.ecole.archery.view.controller.GameController;


public class MainTitlePresenter {

    public void createGame(GameController gameController, int numberOfArrows) {
        ModelDomain model = new ModelDomain();
        model.setNumberOfArrow(numberOfArrows);
        gameController.setModelDomain(model);
        gameController.launchGamePresenter();
    }

}