package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Rain_Trapping {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums =
	 * {0,1,0,2,1,0,1,3,2,1,2,1}; int res; res = trap(nums);
	 * System.out.println(res);
	 * 
	 * }
	 */
//http://www.goodtecher.com/leetcode-42-trapping-rain-water/
	public static int trap(int[] height) {

		if(height.length==0) return 0;

	    int[] leftHeighest=new int[height.length];
	    int[] rightHeighest=new int[height.length];
	    int max=height[0];
	    for(int i =0;i<height.length;i++) {
	        if(height[i]>max) max=height[i];
	        leftHeighest[i]=max;
	    }
	    max=height[height.length-1];
	    for(int i=height.length-1;i>=0;i--){
	        if(height[i]>max) max=height[i];
	        rightHeighest[i]=max;
	    }
	    int sum=0;
	    for(int i=0;i<height.length;i++){
	     sum=sum+Math.min(leftHeighest[i],rightHeighest[i])-height[i];
	    }
	    return sum;

	}
}
