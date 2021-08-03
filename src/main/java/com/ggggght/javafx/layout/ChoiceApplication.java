package com.ggggght.javafx.layout;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceApplication extends Application {
  Stage window;

  @Override
  public void start(Stage stage) throws IOException {
    window = stage;
    window.setTitle("This is a title");

    ChoiceBox<String> choiceBox = new ChoiceBox<>();
    choiceBox.getItems().addAll(List.of("Apples", "Bananas", "Bacon", "Ham"));
    // set default value it must exist
    choiceBox.setValue("Apples");
    // listen for selection changes
    choiceBox.getSelectionModel().selectedItemProperty().addListener((a, oValue, nValue) -> {
      System.out.println(nValue);
    });

    Button button = new Button("Order Now!");
    button.setOnAction(e -> handleChoice(choiceBox, choiceBox.getValue()));
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(choiceBox, button);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void handleChoice(ChoiceBox<String> choiceBox, String value) {
    choiceBox.getItems().forEach(a -> System.out.printf("%s\t", a));

    System.out.println("value = " + value);
  }

  public static void main(String[] args) {
    launch();
  }
}
