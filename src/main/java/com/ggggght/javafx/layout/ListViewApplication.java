package com.ggggght.javafx.layout;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewApplication extends Application {
  Stage window;
  ListView<String> listView;
  @Override
  public void start(Stage stage) throws IOException {
    window = stage;
    window.setTitle("This is a title");

    listView = new ListView<>();
    listView.getItems().addAll(List.of("C++", "GoLang", "Java", "JavaScript"));
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    Button button = new Button("Order Now!");
    button.setOnAction(e -> handleView());
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(listView, button);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void handleView() {
    final ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
    for (String selectedItem : selectedItems) {
      System.out.println(selectedItem);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
