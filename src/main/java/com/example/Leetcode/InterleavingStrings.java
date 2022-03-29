package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

	public static void main(String[] args) {
		String a = "aa";
		String b = "bb";
		String c = "aabb";
		boolean res = isInterleaving(a,b,c,new HashMap<>());
		System.out.print(res);

	}

	 private static boolean isInterleaving(String a, String b, String c, Map<String, Boolean> map){
	        if(a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
	        String key = a + "->" + b + "->" + c;
	        boolean resultOne = false;
	        boolean resultTwo = false;
	        if(!map.containsKey(key)){
	            if(!a.isEmpty() && a.charAt(0) == c.charAt(0)) resultOne = isInterleaving(a.substring(1), b, c.substring(1), map);
	            if(!b.isEmpty() && b.charAt(0) == c.charAt(0)) resultTwo = isInterleaving(a, b.substring(1), c.substring(1), map);
	            map.put(key, resultOne || resultTwo);
	        }
	        return map.get(key);
	    }
	    public boolean isInterleave(String s1, String s2, String s3) {
	        if(s1.length() + s2.length() != s3.length()) return false;
	        return isInterleaving(s1, s2, s3, new HashMap<>());
	    }
}
