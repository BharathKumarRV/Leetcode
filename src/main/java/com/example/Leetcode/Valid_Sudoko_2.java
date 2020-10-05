package com.example.Leetcode;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;

public class Valid_Sudoko_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		boolean res = isValidSudoku_2(board);
		System.out.println(res);

	}

	public static boolean isValidSudoku(char[][] board) {

		short[] rows = new short[9];
		short[] cols = new short[9];
		short[] squares = new short[9];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.')
					continue;

				short value = (short) (1 << (board[row][col] - '1'));

				if ((value & rows[row]) > 0)
					return false;
				if ((value & cols[col]) > 0)
					return false;
				if ((value & squares[3 * (row / 3) + col / 3]) > 0)
					return false;

				rows[row] |= value;
				cols[col] |= value;
				squares[3 * (row / 3) + col / 3] |= value;
			}
		}

		return true;
	}

	public static boolean isValidSudoku_2(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> columns = new HashSet<Character>();
			HashSet<Character> cube = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !columns.add(board[j][i]))
					return false;
				int RowIndex = 3 * (i / 3); //gives start of each block    00,03,06
				int ColIndex = 3 * (i % 3);                             // 30,33,36
				if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'    // 60,63,66 
						&& !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
					return false;
			}
		}
		return true;
	}
}
