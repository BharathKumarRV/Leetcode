package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Word_search_matrix {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean res = exist(board, "SEE");
		System.out.println(res);

	}

	static boolean[][] visited;

	public static boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((word.charAt(0) == board[i][j]) && search_2(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean search(char[][] board, int i, int j, String word, int idx) {
		if (idx == word.length() - 1) {
			return true;
		}
		visited[i][j] = true;
		if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(idx + 1)
				&& search(board, i - 1, j, word, idx + 1))
			return true;
		if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(idx + 1)
				&& search(board, i, j - 1, word, idx + 1))
			return true;
		if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(idx + 1)
				&& search(board, i + 1, j, word, idx + 1))
			return true;
		if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(idx + 1)
				&& search(board, i, j + 1, word, idx + 1))
			return true;

		visited[i][j] = false;
		return false;
	}

	private static boolean search_2(char[][] board, int i, int j, String word, int index) {
		if (index == word.length()) {
			return true;
		}

		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
				|| visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		if (search_2(board, i - 1, j, word, index + 1) || search_2(board, i + 1, j, word, index + 1)
				|| search_2(board, i, j - 1, word, index + 1) || search_2(board, i, j + 1, word, index + 1)) {
			return true;
		}

		visited[i][j] = false;
		return false;
	}
}
