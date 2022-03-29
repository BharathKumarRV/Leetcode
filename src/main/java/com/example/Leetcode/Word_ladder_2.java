package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_ladder_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		List<List<String>> res = findLadders("hit", "cog", wordList);
		System.out.print(res);

	}
	
	 private static class Node {
	        public String value;
	        public Node previous;
	        Node(String value) { this.value = value; }
	        Node(String value, Node previous) {
	            this.value = value;
	            this.previous = previous;
	        }
	    }

		public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        List<List<String>> res = new ArrayList<>();
	        Set<String> list = new HashSet<>(wordList);
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(new Node(beginWord));
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            while(size-->0){
	                Node head = queue.poll();
	                for (String neighborStr : neighbors(list, head.value)) {
	                    Node neighbor = new Node(neighborStr, head);
	                    if (neighbor.value.equals(endWord)) {
	                        addNode(res, neighbor);
	                        break;
	                    }
	                    queue.offer(neighbor);
	                }
	            }
	            if (res.size() > 0) break;
	        }
	        return res;
	    }
	    


	    private static  Set<String> neighbors(Set<String> list, String s) {
	            list.remove(s);
	            Set<String> res = new HashSet<>();
	            char[] chars = s.toCharArray();
	            for (int i = 0; i < s.length(); i++) {
	                for (char ch = 'a'; ch <= 'z'; ch++) {
	                    if (chars[i] == ch) continue;
	                    char tmp = chars[i];
	                    chars[i] = ch;
	                    String word = new String(chars);
	                    if (list.contains(word)) res.add(word);
	                    chars[i] = tmp;
	                }
	            }
	            return res;
	        }


	     private static  void addNode(List<List<String>> list, Node p) {
	        LinkedList<String> ladder = new LinkedList<>();
	        while (p != null) {
	            ladder.addFirst(p.value);
	            p = p.previous;
	        }
	        list.add(ladder);
	    }

}
