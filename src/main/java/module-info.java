module com.genuineappsgroup {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.genuineappsgroup to javafx.fxml;
    exports com.genuineappsgroup;
}
