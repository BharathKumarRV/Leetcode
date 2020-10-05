package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Word_search_matrix {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		boolean res = exist(board, "ABCB");
		System.out.println(res);

	}

	static boolean[][] visited;

	public static boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean search(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}

		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
				|| visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
				|| search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
			return true;
		}

		visited[i][j] = false;
		return false;
	}
}
