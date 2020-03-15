package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Can_Jump {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums=
	 * {2,3,1,1,4}; boolean res=canJump(nums); System.out.println(res);
	 * 
	 * }
	 */

	public static boolean canJump(int[] nums) {
		int lastGoodIndexPosition=nums.length-1;
		
		for(int i=nums.length-1;i>=0;i--) {
			if(i+nums[i]>=lastGoodIndexPosition) {
				lastGoodIndexPosition=i;
			}
		}
		
		return lastGoodIndexPosition==0;
	}
}
