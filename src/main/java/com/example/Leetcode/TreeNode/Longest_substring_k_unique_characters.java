package com.example.Leetcode.TreeNode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.LeetcodeApplication;

public class Longest_substring_k_unique_characters {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = "aabbcc"; 
        int k = 2; 
        String res=kUniques(s, k);
        System.out.println(res);

	}
	
	public static String kUniques(String s, Integer m) 
	{
		
/*		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int uniqChars = 0;
		int size = s.length();
		
		for(int i=0; i<size;i++)
		{
			int ch = (int)s.charAt(i);
			if(!hash.containsKey(ch))
			{
				uniqChars++;
				hash.put(ch, 1);
				
			}
			else
			{
				int temp =  hash.get(ch);
				hash.put(ch,++temp);
			}
		}
		
		if(uniqChars < m)
		{
			throw new Exception("only " + uniqChars + " unique characters are found");
		}*/
		
		
		int start =0, end=0, windowSize =1, windowStart = 0;
		int size = s.length();
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int ch = (int)s.charAt(0);
		hash.put(ch, 1);
		
		for(int i=1; i<size;i++)
		{
			ch = (int)s.charAt(i);
			if(!hash.containsKey(ch))
			{
				hash.put(ch, 1);
			}
			else
			{
				int temp =  hash.get(ch);
				hash.put(ch,++temp);
			}
			end++;
			//move start forward if number of unique characters is greater than m
			while(!isLessThanK(hash,m))
			{
				int temp =  hash.get((int)s.charAt(start));
				hash.put((int)s.charAt(start),--temp);
				start++;
			}
			if(end-start+1 >windowSize)
			{
				windowSize = end-start + 1;
				windowStart = start;
			}	
		}
		return s.substring(windowStart, windowStart+windowSize);	
		
		
	}
	
	public static boolean isLessThanK(HashMap<Integer,Integer> hash, Integer m)
	{
		int count =0;
		for(Integer key:hash.keySet())
			if(hash.get(key) > 0) count++;
		
		return (count <= m); 
	}	

}
