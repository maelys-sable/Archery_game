module fr.ensicaen.ecole.archery {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.ensicaen.ecole.archery to javafx.fxml;
    exports fr.ensicaen.ecole.archery;
}