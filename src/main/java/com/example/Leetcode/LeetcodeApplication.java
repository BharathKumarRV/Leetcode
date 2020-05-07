package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums= {4,1,2,1,2};
		int res = singleNumber(nums);
		System.out.println(res);

	}

	public static int singleNumber(int[] A) {
        
	      Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	      
	      for(int i:A){
	    	  map.put(i,map.getOrDefault(i,0)+1);
	      }
	        
	      for(int key:map.keySet()) {
	    	  if(map.get(key)==1) {
	    		  return key;
	    	  }
	      }
	      
	      return -1;
	      
	    }
}