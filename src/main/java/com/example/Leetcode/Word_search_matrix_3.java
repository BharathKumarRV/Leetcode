package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Word_search_matrix_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> res = findWords(board, words);
		System.out.println(res);

	}

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		boolean[][] visited;
		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res, visited);
			}
		}
		return res;
	}

	public static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res, boolean[][] visited) {
		char c = board[i][j];
		if (visited[i][j] || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate
		}

		visited[i][j] = true;
		if (i > 0)
			dfs(board, i - 1, j, p, res, visited);
		if (j > 0)
			dfs(board, i, j - 1, p, res, visited);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res, visited);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res, visited);
		visited[i][j] = false;
	}

	public static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}
