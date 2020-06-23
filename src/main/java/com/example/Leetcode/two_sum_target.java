package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class two_sum_target {

	public static void main(String[] args) {
		int nums[]= {2,7,11,15};
		int res[] = twoSum1(nums,13);
		System.out.println(res[0]+ " "+res[1]);
	}
	
	public static int[] twoSum1(int[] numbers, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    int[] ret = new int[2];
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target-numbers[i])) {
	            ret[0] = map.get(target-numbers[i]) + 1;
	            ret[1] = i+1;
	            break;
	        }
	        map.put(numbers[i], i);
	    }
	    return ret;
	}
	
	/*
	 * public static int[] twoSum(int[] nums, int target) { int res[]=new int[2];
	 * int i=0; int j=nums.length-1; while(i<j){ int sum=nums[i]+nums[j];
	 * if(sum==target){ res[0]=i+1; res[1]=j+1; return res; } else if(sum<target){
	 * i++; } else if(sum>target){ j--; } }
	 * 
	 * return res; }
	 */
}
