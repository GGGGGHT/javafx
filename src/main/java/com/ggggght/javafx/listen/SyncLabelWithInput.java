package com.ggggght.javafx.listen;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class SyncLabelWithInput extends Application {
  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Add listener");

    TextField userInput = new TextField();
    userInput.setMinWidth(200);
    Label firstLabel = new Label("Welcome to thie site ");
    Label secondLabel = new Label();
    secondLabel.textProperty().bind(userInput.textProperty());

    HBox bottomText = new HBox(firstLabel, secondLabel);
    bottomText.setAlignment(Pos.CENTER);

    VBox vBox = new VBox(10, userInput, bottomText);
    vBox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(vBox, 300, 200);
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
