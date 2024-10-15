module fr.ensicaen.ecole.archery {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.ensicaen.ecole.archery to javafx.fxml;
    exports fr.ensicaen.ecole.archery;
    exports fr.ensicaen.ecole.archery.presenter;
    opens fr.ensicaen.ecole.archery.presenter to javafx.fxml;
    exports fr.ensicaen.ecole.archery.view;
    opens fr.ensicaen.ecole.archery.view to javafx.fxml;
    exports fr.ensicaen.ecole.archery.view.controller;
    opens fr.ensicaen.ecole.archery.view.controller to javafx.fxml;
    exports fr.ensicaen.ecole.archery.view.bow;
    opens fr.ensicaen.ecole.archery.view.bow to javafx.fxml;
    exports fr.ensicaen.ecole.archery.model.space;
    opens fr.ensicaen.ecole.archery.model.space to javafx.fxml;
}