package com.example.Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_ladder {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		int res = ladderLength("hit", "cog", wordList);
		System.out.print(res);

	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		Set<String> set = new HashSet<String>(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList();
		queue.offer(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String current_word = queue.poll();
				char[] word_chars = current_word.toCharArray();
				for (int j = 0; j < word_chars.length; j++) {
					char original_char = word_chars[j];
					for (char c = 'a'; c <= 'z'; c++) {
						word_chars[j] = c;
						String new_word = String.valueOf(word_chars);
						if (new_word.equals(endWord))
							return level + 1;
						if (set.contains(new_word)) {
							System.out.println(new_word);
							queue.offer(new_word);
							set.remove(new_word);
						}
					}
					word_chars[j] = original_char;
				}

			}
			level++;
		}
		return 0;

	}

}
