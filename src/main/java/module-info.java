module com.genuineappsgroup {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.genuineappsgroup to javafx.fxml;
    exports com.genuineappsgroup;
}
