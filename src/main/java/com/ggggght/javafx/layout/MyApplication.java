package com.ggggght.javafx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class MyApplication extends Application {
	Stage window;
	@Override
	public void start(Stage stage) throws IOException {
		window = stage;
		window.setTitle("This is a title");


		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("GGGGGHT");
		GridPane.setConstraints(nameInput, 1, 0);

		Label password = new Label("Password: ");
		GridPane.setConstraints(password , 0, 1);
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("password");
		GridPane.setConstraints(passwordInput, 1, 1);
		Button loginButton = new Button("Log In");
		loginButton.setOnAction(e -> checkInt(passwordInput, passwordInput.getText()));
		GridPane.setConstraints(loginButton, 1, 2);

		grid.getChildren().addAll(nameInput, nameLabel, password, passwordInput, loginButton);
		Scene scene = new Scene(grid,300,200);
		window.setScene(scene);

		window.show();
	}

	private boolean checkInt(TextField field,String msg) {
		try {
			int age = Integer.parseInt(msg);
			System.out.println("age = " + age);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Error: " + msg + " is not a num!");
			return false;
		}
	}
	public static void main(String[] args) {
		launch();
	}
}
