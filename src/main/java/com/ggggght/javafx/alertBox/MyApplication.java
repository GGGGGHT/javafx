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
		button.setOnAction(e -> closeWindow(stage));
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e -> {
			e.consume();
			closeWindow(stage);
		});
	}

	public static void main(String[] args) {
		launch();
	}

	private void closeWindow(Stage stage) {
		boolean close = ConfirmBox.display("Close Window.", "Are you sure?");
		if (close)
			stage.close();
	}
}
