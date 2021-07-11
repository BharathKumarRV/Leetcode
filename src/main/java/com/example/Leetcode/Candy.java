package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

public class Candy {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int ratings[] = { 1, 2, 87, 87, 87, 2, 1 };
		int res = candy_2(ratings);
		System.out.println(res);
	}

	public static int candy(int ratings[]) {
		int size = ratings.length;
		if (size <= 1)
			return size;
		int num[] = new int[size];
		Arrays.fill(num, 1);
		for (int i = 1; i < size; i++) {
			if (ratings[i] > ratings[i - 1])
				num[i] = num[i - 1] + 1;
		}
		for (int i = size - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i])
				num[i - 1] = Math.max(num[i] + 1, num[i - 1]);
		}
		int result = 0;
		for (int i = 0; i < size; i++) {
			result += num[i];
		}
		return result;
	}
	
	
	 public static int candy_2(int[] ratings) {
	       int n = ratings.length;
	        
	        int[] leftArr = new int[n];
	        int[] rightArr = new int[n];
	        
	        for(int i=0;i<n;i++){
	            leftArr[i] = 1;
	            rightArr[i] = 1;
	        }
	        
	        for(int i=1;i<n;i++){
	            if(ratings[i] > ratings[i-1] && leftArr[i] <= leftArr[i-1]){
	                leftArr[i] = leftArr[i-1]+1;
	            }
	        }
	        
	        for(int i=n-1;i>0;i--){
	            if(ratings[i-1] > ratings[i] && rightArr[i-1] <= rightArr[i]){
	                rightArr[i-1] = rightArr[i]+1;
	            }
	        }
	        
	        // System.out.println(Arrays.toString(leftArr));
	        // System.out.println(Arrays.toString(rightArr));
	        
	        int sum = 0;
	        for(int i=0;i<n;i++){
	            sum += Math.max(leftArr[i], rightArr[i]);
	        }
	        return sum;
	    }

}
