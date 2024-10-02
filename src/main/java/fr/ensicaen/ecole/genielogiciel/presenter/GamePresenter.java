package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.Player;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public final class GamePresenter {
    private final Player _model;
    private GameView _view;
    private boolean _end = false;

    public GamePresenter( String nickName ) {
        _model = new Player();
        _model.setNickname(nickName);
    }

    public void setView( GameView view ) {
        _view = view;
    }

    public void runGameLoop() {
        System.out.println("Et c'est parti...");
    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
}