package com.main;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FirstStage {

	private Scene scene;
	private Button solveButton, clearButton;
	private BorderPane bigPane;
	private GridPane grid;
	private int width = 900;
	private int height = 900;
	private int[][] values;

	public Scene getScene() {
		return scene;
	}

	public void setScene() {

		bigPane = new BorderPane();
		solveButton = new Button("Solve!");
		clearButton = new Button("Clear");

		VBox topBox = new VBox(10);
		topBox.setAlignment(Pos.CENTER);

		HBox botBox = new HBox(10);
		botBox.setAlignment(Pos.CENTER);
		botBox.getChildren().addAll(solveButton, clearButton);

		GridPane midGrid = createGrid(9, 9);

		bigPane.setTop(topBox);
		bigPane.setCenter(midGrid);
		bigPane.setBottom(botBox);

		this.scene = new Scene(bigPane, width, height);
		solveButton.setOnAction(e -> writeSol());
		clearButton.setOnAction(e -> clear());
	}

	public GridPane createGrid(int rows, int cols) {
		grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);

		int cellSize = 50;

		for (int blockRow = 0; blockRow < 3; blockRow++) {
			for (int blockCol = 0; blockCol < 3; blockCol++) {
				GridPane block = new GridPane();
				block.setHgap(1);
				block.setVgap(1);
				block.setStyle("-fx-border-color: black; -fx-border-width: 2;");

				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						TextField tf = new TextField();
						tf.setPrefSize(cellSize, cellSize);
						tf.setAlignment(Pos.CENTER);
						tf.setStyle("-fx-border-color: gray; -fx-font-size: 24px;");

						tf.textProperty().addListener((obs, oldText, newText) -> {
							if (!newText.matches("[1-9]?")) {
								tf.setText(oldText);
							}
						});

						block.add(tf, col, row);
					}
				}

				grid.add(block, blockCol, blockRow);
			}
		}

		return grid;
	}

	public int[][] getGridValues() {

		values = new int[9][9];

		for (int blockRow = 0; blockRow < 3; blockRow++) {
			for (int blockCol = 0; blockCol < 3; blockCol++) {
				Node blockNode = getNodeFromGrid(grid, blockCol, blockRow);
				if (blockNode instanceof GridPane subGrid) {
					for (int cellRow = 0; cellRow < 3; cellRow++) {
						for (int cellCol = 0; cellCol < 3; cellCol++) {
							int globalRow = blockRow * 3 + cellRow;
							int globalCol = blockCol * 3 + cellCol;

							Node cellNode = getNodeFromGrid(subGrid, cellCol, cellRow);
							if (cellNode instanceof TextField tf) {
								String text = tf.getText().trim();
								int val = 0;
								if (!text.isEmpty()) {
									try {
										val = Integer.parseInt(text);
									} catch (NumberFormatException e) {
										val = 0;
									}
								}
								values[globalRow][globalCol] = val;
							}
						}
					}
				}
			}
		}

		return values;
	}

	private Node getNodeFromGrid(GridPane grid, int col, int row) {
		for (Node node : grid.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}

	public int[][] solve() {
		values = getGridValues();
		Sudoku.setGrid(values);
		Sudoku.sudokuSolver();
		int[][] sol = Sudoku.getSol();
		return sol;
	}

	public void writeSol() {
		int[][] solution = solve();
		for (int blockRow = 0; blockRow < 3; blockRow++) {
			for (int blockCol = 0; blockCol < 3; blockCol++) {
				Node blockNode = getNodeFromGrid(grid, blockCol, blockRow);
				if (blockNode instanceof GridPane subGrid) {
					for (int cellRow = 0; cellRow < 3; cellRow++) {
						for (int cellCol = 0; cellCol < 3; cellCol++) {
							int globalRow = blockRow * 3 + cellRow;
							int globalCol = blockCol * 3 + cellCol;

							Node cellNode = getNodeFromGrid(subGrid, cellCol, cellRow);
							if (cellNode instanceof TextField tf) {
								int val = solution[globalRow][globalCol];
								tf.setText(val == 0 ? "" : String.valueOf(val));
							}
						}
					}
				}
			}
		}
	}

	public void clear() {
		for (int blockRow = 0; blockRow < 3; blockRow++) {
			for (int blockCol = 0; blockCol < 3; blockCol++) {
				Node blockNode = getNodeFromGrid(grid, blockCol, blockRow);
				if (blockNode instanceof GridPane subGrid) {
					for (int cellRow = 0; cellRow < 3; cellRow++) {
						for (int cellCol = 0; cellCol < 3; cellCol++) {
							Node cellNode = getNodeFromGrid(subGrid, cellCol, cellRow);
							if (cellNode instanceof TextField tf) {
								tf.setText("");
							}
						}
					}
				}
			}
		}

	}

}