package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Prefix_tree {

	static class TrieNode {
	    public boolean isWord; 
	    public TrieNode[] children = new TrieNode[26];
	    public TrieNode() {}
	}
	
	public static class Trie {
	    private static TrieNode root;
	    public Trie() {
	        root = new TrieNode();
	    }

	    public static void insert(String word) {
	        TrieNode ws = root;
	        for(int i = 0; i < word.length(); i++){
	            char c = word.charAt(i);
	            if(ws.children[c - 'a'] == null){
	                ws.children[c - 'a'] = new TrieNode();
	            }
	            ws = ws.children[c - 'a'];
	        }
	        ws.isWord = true;
	    }

	    public static boolean search(String word) {
	        TrieNode ws = root; 
	        for(int i = 0; i < word.length(); i++){
	            char c = word.charAt(i);
	            if(ws.children[c - 'a'] == null) return false;
	            ws = ws.children[c - 'a'];
	        }
	        return ws.isWord;
	    }

	    public static boolean startsWith(String prefix) {
	        TrieNode ws = root; 
	        for(int i = 0; i < prefix.length(); i++){
	            char c = prefix.charAt(i);
	            if(ws.children[c - 'a'] == null) return false;
	            ws = ws.children[c - 'a'];
	        }
	        return true;
	    }
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		Trie trie=new Trie();
		Trie.insert("apple");
		Trie.insert("bat");
		boolean res=Trie.search("apple");
		System.out.println(res);
		boolean res1=Trie.startsWith("app");
		System.out.println(res1);
		

	}
}
