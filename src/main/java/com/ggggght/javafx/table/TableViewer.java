package com.ggggght.javafx.table;

import java.util.Objects;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class TableViewer extends Application {
  Stage window;
  TableView<Product> tableView;
  TextField nameInput, quantityInput, priceInput;

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

    nameInput = new TextField();
    nameInput.setPromptText("Name");
    nameInput.setMinWidth(100);

    quantityInput = new TextField();
    quantityInput.setPromptText("Quantity");

    priceInput = new TextField();
    priceInput.setPromptText("Price");

    final ObservableList<Product> products = getProduct();

    Button addButton = new Button("Add");
    addButton.setOnAction(e -> {
      final String name = nameInput.getText();
      if (Objects.isNull(name) || name.length() == 0) {
        return;
      }

      final String price = priceInput.getText();
      if (Objects.isNull(price) || price.length() == 0) {
        return;
      }

      final String quantity = quantityInput.getText();
      if (Objects.isNull(quantity) || quantity.length() == 0) {
        return;
      }

      final Product product = new Product(name, Double.valueOf(price),
          Integer.valueOf(quantity));

      tableView.getItems().add(product);
      nameInput.clear();
      priceInput.clear();
      quantityInput.clear();
    });
    Button deleteButton = new Button("delete");
    deleteButton.setOnAction(e -> {
      final Product selectedItem = tableView.getSelectionModel().getSelectedItem();
      if (Objects.isNull(selectedItem)) {
        return;
      }

      tableView.getItems().remove(selectedItem);
      System.out.println("delete secuess");
    });

    HBox hBox = new HBox();
    hBox.setPadding(new Insets(10, 10, 10, 10));
    hBox.setSpacing(10);
    hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

    tableView = new TableView<>(products);
    tableView.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
    VBox vBox = new VBox();
    vBox.getChildren().addAll(tableView, hBox);

    Scene scene = new Scene(vBox);
    window.setScene(scene);
    window.show();
  }

  public ObservableList<Product> getProduct() {
    ObservableList<Product> products = FXCollections.observableArrayList();
    products.addAll(
        new Product("Laptop", 55, 10),
        new Product("Ping pong", 1, 20),
        new Product("Cron", 500, 2),
        new Product("Toilet", 100.5, 5),
        new Product("Bouncy Ball", 1.48, 20)
    );

    return products;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
