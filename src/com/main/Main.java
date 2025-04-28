package com.main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FirstStage window = new FirstStage();
		window.setScene();
		primaryStage.setTitle("Sudoku Solver");
		primaryStage.setScene(window.getScene());
		primaryStage.show();

	}

}
