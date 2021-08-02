package com.ggggght.javafx.alertBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class MyApplication extends Application {
	Stage window;
	@Override
	public void start(Stage stage) throws IOException {
		window = stage;
		window.setTitle("This is a title");

		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

		VBox leftMenu = new VBox();
		Button buttonD = new Button("Project");
		Button buttonE = new Button("Commit");
		Button buttonF = new Button("pull Requests");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(leftMenu);
		borderPane.setTop(topMenu);

		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();
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
