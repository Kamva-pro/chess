package com.genuineappsgroup;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DragExample extends Application {
@Override
public void start(Stage primaryStage) {
Pane pane = new Pane();
Text text = new Text(20, 20, "Programming is fun");
pane.getChildren().add(text);
text.setOnMouseDragged(e -> { 
text.setX(e.getX());
text.setY(e.getY());
});
Scene scene = new Scene(pane, 300, 100);
primaryStage.setTitle("MouseEventDemo");
primaryStage.setScene(scene);
primaryStage.show();
}
public static void main(String[] args) {
launch(args);
}
}

