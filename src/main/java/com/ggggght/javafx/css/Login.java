package com.ggggght.javafx.css;

import com.ggggght.javafx.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class Login  extends Application {
  Stage window;
  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    GridPane pane = new GridPane();
    Label labelA = new Label("LabelA");
    labelA.setId("bold-label");
    labelA.setStyle("-fx-text-fill: #F00");
    Label labelB = new Label("LabelB");
    VBox vBox = new VBox(10);
    final Button button = new Button("hello world");
    Button button_bule = new Button("blue...");
    button_bule.getStyleClass().add("button-blue");
    GridPane.setConstraints(button_bule, 1, 3);
    button.setOnAction(e-> {
      System.out.println("hello world");
    });
    vBox.getChildren().addAll(labelA, labelB, button,button_bule);
    pane.getChildren().addAll(vBox);
    // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(pane, 320, 240);

    scene.getStylesheets().add(HelloApplication.class.getResource("viper.css").toExternalForm());
    window.setScene(scene);
    window.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
