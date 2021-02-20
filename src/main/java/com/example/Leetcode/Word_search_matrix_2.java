package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Word_search_matrix_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean res = exist(board, "ABCC");
		System.out.println(res);

	}

	public static boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((word.charAt(0) == board[i][j]) && search(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean search(char[][] board, int i, int j, String word, int idx) {
		if (idx == word.length()) {
			return true;
		}

		board[i][j] -= 65;
		if (i > 0 && board[i - 1][j] == word.charAt(idx + 1) && search(board, i - 1, j, word, idx + 1))
			return true;
		if (j > 0 && board[i][j - 1] == word.charAt(idx + 1) && search(board, i, j - 1, word, idx + 1))
			return true;
		if (i < board.length - 1 && board[i + 1][j] == word.charAt(idx + 1) && search(board, i + 1, j, word, idx + 1))
			return true;
		if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(idx + 1)
				&& search(board, i, j + 1, word, idx + 1))
			return true;

		board[i][j] += 65;
		return false;
	}

}
