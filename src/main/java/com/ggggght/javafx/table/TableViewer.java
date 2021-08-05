package com.ggggght.javafx.table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class TableViewer extends Application {
  Stage window;
  TableView<Product> tableView;
  TextField nameInput,quantityInput, priceInput;

  @Override public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("JavaFX - table");

    TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setMinWidth(150);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
    priceColumn.setMinWidth(100);
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

    TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
    quantityColumn.setMinWidth(150);
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    tableView = new TableView<>(getProduct());
    tableView.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
    VBox vBox = new VBox();
    vBox.getChildren().addAll(tableView);

    Scene scene = new Scene(vBox);
    window.setScene(scene);
    window.show();
  }

  public ObservableList<Product> getProduct() {
    ObservableList<Product> products = FXCollections.observableArrayList();
    products.addAll(
        new Product("Laptop",55,10),
        new Product("Ping pong",1,20),
        new Product("Cron",500,2),
        new Product("Toilet",100.5,5),
        new Product("Bouncy Ball",1.48,20)
    );

    return products;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
