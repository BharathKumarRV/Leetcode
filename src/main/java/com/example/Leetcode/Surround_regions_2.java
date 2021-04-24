package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Surround_regions_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
		System.out.println();

	}

	static boolean seen;

	public static void mark(char[][] board, int i, int j, int r, int c) {
		if (i < 0 || i > r - 1 || j < 0 || j > c - 1)
			return;
		if (board[i][j] == 'X')
			return;

		board[i][j] = 'X';
		mark(board, i - 1, j, r, c);
		mark(board, i + 1, j, r, c);
		mark(board, i, j - 1, r, c);
		mark(board, i, j + 1, r, c);
	}

	public static void dfs(char[][] board, int i, int j, int r, int c, boolean[][] visited) {
		if (i < 0 || i > r - 1 || j < 0 || j > c - 1)
			return;

		if (board[i][j] == 'X' || visited[i][j])
			return;
		if (i == 0 || i == r - 1 || j == 0 || j == c - 1)
			seen = true;

		visited[i][j] = true;
		dfs(board, i - 1, j, r, c, visited);
		dfs(board, i + 1, j, r, c, visited);
		dfs(board, i, j - 1, r, c, visited);
		dfs(board, i, j + 1, r, c, visited);
	}

	public static void solve(char[][] board) {

		int r = board.length;
		if (r <= 1)
			return;
		int c = board[0].length;
		if (c <= 1)
			return;

		boolean[][] visited = new boolean[r][c];

		for (int i = 1; i < r - 1; ++i) {
			for (int j = 1; j < c - 1; ++j) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					seen = false;
					dfs(board, i, j, r, c, visited);
					if (seen == false)
						mark(board, i, j, r, c);
					seen = true;
				}
			}
		}
	}
}
