module aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.fasterxml.jackson.databind;


    exports view;
    opens view to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}