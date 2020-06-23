package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.Prefix_tree.Trie;

public class Add_search_word {

	 public static class TrieNode {
	        public TrieNode[] children;
	        public boolean isWord;
	        public TrieNode() {
	        	this.children=new TrieNode[26];
	        	this.isWord=false;
	        }
	    }
	    
	    private TrieNode root = new TrieNode();

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        TrieNode node = root;
	        for (char c : word.toCharArray()) {
	            if (node.children[c - 'a'] == null) {
	                node.children[c - 'a'] = new TrieNode();
	            }
	            node = node.children[c - 'a'];
	        }
	        node.isWord = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return match(word.toCharArray(), 0, root);
	    }
	    
	    private boolean match(char[] chs, int k, TrieNode node) {
	        if (k == chs.length) {
	            return node.isWord;
	        }
	        if (chs[k] == '.') {
	            for (int i = 0; i < node.children.length; i++) {
	                if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
	                    return true;
	                }
	            }
	        } else {
	            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
	        }
	        return false;
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		TrieNode trie=new TrieNode();
		Add_search_word obj=new Add_search_word();
		obj.addWord("apple");
		obj.addWord("bat");
		boolean res=obj.search("apple");
		System.out.println(res);
		boolean res1=obj.search("bat");
		System.out.println(res1);
		boolean res2=obj.search("a....");
		System.out.println(res2);
		

	}
}
