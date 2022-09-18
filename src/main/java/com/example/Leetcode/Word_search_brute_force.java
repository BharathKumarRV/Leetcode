package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_search_brute_force {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> res = findWords(board, words);
		System.out.println(res);

	}

	static boolean[][] visited;

	public static List<String> findWords(char[][] board, String[] words) {

		Set<String> res = new HashSet<String>();
		for (String word : words) {
			visited = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (!res.contains(word)) {
						if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
							res.add(word);
						}
					}
				}
			}

		}

		return new ArrayList<String>(res);

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
