package com.ggggght.javafx.layout;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RadioApplication extends Application {
  Stage window;
  BorderPane layout;
  @Override
  public void start(Stage stage) throws IOException {
    window = stage;
    window.setTitle("This is a title");

    Menu fileMenu = new Menu("File");
    final MenuItem newFile = new MenuItem("New");
    newFile.setOnAction(e -> System.out.println("create new file..."));
    fileMenu.getItems().add(newFile);
    fileMenu.getItems().add(new MenuItem("Open"));
    fileMenu.getItems().add(new MenuItem("Open Recent"));
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Settings..."));
    fileMenu.getItems().add(new SeparatorMenuItem());
    final MenuItem exit = new MenuItem("Exit");
    fileMenu.getItems().add(exit);
    exit.setOnAction(e -> window.close());

    Menu editMenu = new Menu("_Edit");
    editMenu.getItems().add(new MenuItem("Cut"));
    editMenu.getItems().add(new MenuItem("Copy"));
    final MenuItem paste = new MenuItem("Paste");
    paste.setDisable(true);
    editMenu.getItems().add(paste);

    Menu helpMenu = new Menu("_Help");
    final CheckMenuItem showLines = new CheckMenuItem("Show lines");
    showLines.setSelected(true);
    showLines.setOnAction(e -> {
      if (showLines.isSelected()) {
        System.out.println("Program will now display line Number");
      } else {
        System.out.println("Hiding line number");
      }
    });
    helpMenu.getItems().add(showLines);
    Menu difficultMenu = new Menu("Difficulty");
    ToggleGroup difficultyToggle = new ToggleGroup();
    RadioMenuItem easy = new RadioMenuItem("Easy");
    RadioMenuItem medium = new RadioMenuItem("Medium");
    RadioMenuItem hard = new RadioMenuItem("Hard");

    easy.setToggleGroup(difficultyToggle);
    medium.setToggleGroup(difficultyToggle);
    hard.setToggleGroup(difficultyToggle);
    difficultMenu.getItems().addAll(easy, medium, hard);

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu,difficultMenu);

    layout = new BorderPane();
    layout.setTop(menuBar);
    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }


  public static void main(String[] args) {
    launch();
  }
}
