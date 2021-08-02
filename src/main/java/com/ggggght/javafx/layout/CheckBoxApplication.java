package com.ggggght.javafx.layout;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxApplication extends Application {
	Stage window;
	@Override
	public void start(Stage stage) throws IOException {
		window = stage;
		window.setTitle("This is a title");

		CheckBox checkBox1 = new CheckBox("Apple");
		CheckBox checkBox2 = new CheckBox("Banana");
		checkBox1.setSelected(true);

		Button button = new Button("Order Now!");
		button.setOnAction(e -> handleOptions(checkBox1, checkBox2));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(checkBox1, checkBox2,button);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void handleOptions(CheckBox checkBox1, CheckBox checkBox2) {
		if (checkBox1.isSelected()) {
			System.out.println("checkBox1 is selected");
		}

		if (checkBox2.isSelected()) {
			System.out.println("checkBox2 is selected");
		}
	}

	public static void main(String[] args) {
		launch();
	}
}
