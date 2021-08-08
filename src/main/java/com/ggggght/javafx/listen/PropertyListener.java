package com.ggggght.javafx.listen;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class PropertyListener extends Application {
  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Add listener");

    Person ght = new Person();
    ght.nameProperty().addListener((v, oldvalue, newvalue) -> {
      System.out.println("name changed to = " + newvalue);
      System.out.println("ght.nameProperty() = " + ght.nameProperty());
      System.out.println("ght.getName() = " + ght.getName());
    });
    Label nameLabel = new Label("Input your name: ");
    TextField textField = new TextField();

    textField.setPromptText("you name..");
    Button button = new Button("click me");
    button.setOnAction(e -> {
      ght.setName(textField.getText());
    });
    GridPane gridPane = new GridPane();
    GridPane.setConstraints(nameLabel, 0, 0);
    GridPane.setConstraints(textField, 1, 0);
    GridPane.setConstraints(button, 2, 0);
    gridPane.getChildren().addAll(nameLabel, textField, button);

    Scene scene = new Scene(gridPane, 200, 100);
    window.setScene(scene);
    window.show();
  }

  class Person {
    private StringProperty name = new SimpleStringProperty(this, "firstName", "");

    public String getName() {
      return name.get();
    }

    public StringProperty nameProperty() {
      return name;
    }

    public void setName(String name) {
      this.name.set(name);
    }
  }
}
