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

import fr.ensicaen.ecole.archery.view.Screen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ArcheryApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.png")));
        primaryStage.getIcons().add(icon);
        new Screen(primaryStage).run();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
