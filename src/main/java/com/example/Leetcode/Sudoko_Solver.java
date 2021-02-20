package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Sudoko_Solver {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solveSudoku(board); // System.out.println(res);

	}

	public static void solveSudoku(char[][] board) {

		if (board == null || board.length == 0)
			return;
		boolean res = solve(board);
		System.out.println(res);
	}

	public static boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
						if (isValid(board, i, j, c)) {
							board[i][j] = c; // Put c for this cell
							// We dont know if the above c value is correct
							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}

					return false; //All the posible numbers are executed.
				}
			}
		}
		return true;
	}

	/*
	 * blkrow = (row / 3) * 3 // Multiplying by 3 because we need to move to the
	 * next block
	 * 
	 * board[blkrow + i / 3] // Dividing i by 3 as we have to move one step down in
	 * block
	 * 
	 * board[blkcol + i % 3] // Modulous i by 3 as we have to advance one column
	 * towards right in block
	 * 
	 */

	private static boolean isValid(char[][] board, int row, int col, char c) {
		//Top left element position is obtained by row/3*3 and column/3*3
		int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
		for (int i = 0; i < 9; i++)
			if (board[i][col] == c || board[row][i] == c || board[blkrow + i / 3][blkcol + i % 3] == c)
				return false;
		return true;
	}
}
