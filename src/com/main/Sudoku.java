package com.main;

public class Sudoku {

	public static int[][] grid;

	public static void setGrid(int[][] grid) {
		Sudoku.grid = grid;
	}

	public static boolean sudokuSolver() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (grid[i][j] == 0) {
					for (int k = 1; k < 10; k++) {
						if (possible(i, j, k)) {
							grid[i][j] = k;
							if (sudokuSolver())
								return true;
							grid[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + "|");

			}
			System.out.println();

		}

	}

	public static int[][] getSol() {
		return grid;
	}

	public static boolean possible(int x, int y, int n) {

		for (int i = 0; i < 9; i++) {
			if (grid[x][i] == n)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (grid[i][y] == n)
				return false;
		}

		int x0 = (Math.floorDiv(x, 3)) * 3;
		int y0 = (Math.floorDiv(y, 3)) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[x0 + i][y0 + j] == n)
					return false;

			}
		}
		return true;

	}

}
