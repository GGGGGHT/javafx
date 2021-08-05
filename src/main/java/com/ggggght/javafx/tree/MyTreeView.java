package com.ggggght.javafx.tree;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class MyTreeView extends Application {

  Stage window;

  TreeView<String> tree;
  
  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("JavaFX");

    TreeItem<String> root, bucky, megan;

    root = new TreeItem<>();
    root.setExpanded(false);
    root.setValue("root");

    bucky = makeBranch("bucky",root);
    makeBranch("bucky-1",bucky);
    makeBranch("bucky-2",bucky);
    makeBranch("bucky-3",bucky);

    megan = makeBranch("megan",root);
    makeBranch("megan-1",megan);

    tree = new TreeView<>(root);
    tree.setShowRoot(true);
    tree.getSelectionModel().selectedItemProperty().addListener((observable,o,n)-> {
      System.out.println("n = " + n);
    });

    StackPane pane = new StackPane();
    pane.getChildren().add(tree);
    Scene scene = new Scene(pane, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
    final TreeItem<String> item = new TreeItem<>(name);
    item.setExpanded(false);
    parent.getChildren().add(item);

    return item;
  }

  public static void main(String[] args) {
    launch();
  }
}
