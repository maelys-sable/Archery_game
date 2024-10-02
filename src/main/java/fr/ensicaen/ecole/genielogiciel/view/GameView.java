package fr.ensicaen.ecole.genielogiciel.view;

import fr.ensicaen.ecole.genielogiciel.Main;
import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameView {
    private GamePresenter _gamePresenter;
    private Stage _stage;
    @FXML
    private AnchorPane _board;

    public static GameView createView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("Board.fxml"), Main.getMessageBundle());
        Parent root = fxmlLoader.load();
        final GameView view = fxmlLoader.getController();
        fxmlLoader.setController(view);
        Scene scene = new Scene(root, 1000, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        // TODO ajouter une image
        //      Image image = new Image(getClass().getResourceAsStream("toto.png"));
        view._stage = stage;
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> view.onKeyPressed(event.getCode()));
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, view::onMouseClicked);
        // Pour supprimer l'abonnement à l'événement
//         scene.removeEventFilter(MouseEvent.MOUSE_PRESSED, view::onMouseClicked);
        scene.addEventFilter(MouseEvent.MOUSE_RELEASED, view::onMouseRelased);
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, view::onMouseDragged);
        return view;
    }

    public void setPresenter( GamePresenter gamePresenter ) {
        _gamePresenter = gamePresenter;
    }

    public void show() {
        _stage.show();
    }

    private void onKeyPressed( KeyCode code ) {
        if (code == KeyCode.SPACE) {
            _gamePresenter.runGameLoop();
        }
    }

    private void onMouseClicked( MouseEvent mouseEvent ) {
        System.out.println("mouse clicked detected! (" + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
    }

    private void onMouseRelased( MouseEvent mouseEvent ) {
        System.out.println("mouse released detected! (" + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
    }

    private void onMouseDragged( MouseEvent mouseEvent ) {
        System.out.println("mouse dragged detected! (" + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
    }
}
