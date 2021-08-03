package com.ggggght.javafx.layout;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxApplication extends Application {
  Stage window;
  ComboBox<String> comboBox;
  @Override
  public void start(Stage stage) throws IOException {
    window = stage;
    window.setTitle("This is a title");

    comboBox = new ComboBox<>();
    comboBox.getItems().addAll(List.of("C++", "GoLang", "Java", "JavaScript"));
    comboBox.setEditable(true);
    comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));

    Button button = new Button("Order Now!");
    button.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(comboBox, button);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }


  public static void main(String[] args) {
    launch();
  }
}
