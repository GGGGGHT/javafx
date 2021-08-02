package com.ggggght.javafx.alertBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MyApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		StackPane layout = new StackPane();
		Button button = new Button("This is a Button");
		button.setOnAction(e -> {
			boolean answer = ConfirmBox.display("title...", "Warning: 404");
			System.out.println("answer = " + answer);
		});
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
