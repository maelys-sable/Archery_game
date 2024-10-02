package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.Main;
import fr.ensicaen.ecole.genielogiciel.view.GameView;
import fr.ensicaen.ecole.genielogiciel.view.LoginView;

import java.io.IOException;

public final class LoginPresenter {
    private LoginView _view;

    public void setView( LoginView view ) {
        _view = view;
    }

    public void launchGame( String nickName ) {
        if (nickName.isEmpty()) {
            _view.displayError(Main.getMessageBundle().getString("error.nickname"));
        } else {
            try {
                createAndDisplayGameView(nickName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            _view.close();
        }
    }

    private void createAndDisplayGameView( String nickName ) throws IOException {
        GameView view = GameView.createView();
        GamePresenter gamePresenter = new GamePresenter(nickName);
        view.setPresenter(gamePresenter);
        gamePresenter.setView(view);
        view.show();
    }
}
