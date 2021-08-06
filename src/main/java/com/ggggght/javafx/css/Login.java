package com.ggggght.javafx.css;

import com.ggggght.javafx.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class Login  extends Application {
  Stage window;
  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    GridPane pane = new GridPane();

    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);

    scene.getStylesheets().add(HelloApplication.class.getResource("viper.css").toExternalForm());
    window.setScene(scene);
    window.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
