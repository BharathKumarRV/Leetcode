package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.Prefix_tree.Trie;

public class Prefix_tree_hashmap {

	static class TrieNode{
        Map<Character, TrieNode> charToNode;
        boolean isEnd = false;
        public TrieNode(){
            charToNode = new HashMap();      
        }
        
        
    }
	
	static class Trie {
	    static TrieNode head;
	    /** Initialize your data structure here. */   
	    public Trie() {
	        head = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public static void insert(String word) {
	        if(word == null)
	            return;
	        TrieNode node = head;
	        for(char ch : word.toCharArray()) {
	            if(!node.charToNode.containsKey(ch)){
	                node.charToNode.put(ch, new TrieNode());
	            }
	            node = node.charToNode.get(ch);
	        }
	        node.isEnd = true;
	       
	        
	    }
	    
	    /** Returns if the word is in the trie. */
	    public static boolean search(String word) {
	        if(word == null)
	            return false;
	        TrieNode node = head;
	        for(char ch : word.toCharArray()) {
	            if(!node.charToNode.containsKey(ch)){
	                return false;
	            } 
	            node = node.charToNode.get(ch);
	            
	        }
	        return node.isEnd;
	        
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public static boolean startsWith(String prefix) {
	        if(prefix == null)
	            return false;
	        TrieNode node = head;
	        for(char ch : prefix.toCharArray()) {
	            if(!node.charToNode.containsKey(ch)){
	                return false;
	            } 
	            node = node.charToNode.get(ch);
	            
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