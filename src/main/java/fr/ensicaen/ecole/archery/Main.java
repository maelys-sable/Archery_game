package fr.ensicaen.ecole.archery;

/*
 * ENSICAEN
 * 6 Boulevard Maréchal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students. No portion of this
 * document may be reproduced, copied or revised without written
 * permission of the authors.
 */


import fr.ensicaen.ecole.archery.presenter.MainTitlePresenter;
import fr.ensicaen.ecole.archery.view.GameController;
import fr.ensicaen.ecole.archery.view.MainTitleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTitle extends Application {
    Stage _primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        _primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(MainTitle.class.getResource("MainTitle.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);

        primaryStage.setTitle("Archery");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        MainTitleController mainTitleController = loader.getController();
        mainTitleController.setPrimaryStage(_primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
