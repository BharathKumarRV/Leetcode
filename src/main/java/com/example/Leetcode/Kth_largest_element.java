package com.example.Leetcode;

import java.util.PriorityQueue;

import org.springframework.boot.SpringApplication;

public class Kth_largest_element {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int res = findKthLargest(nums,2);
		System.out.println(res);

	}

	/*
	 * public static int findKthLargest(int[] nums, int k) { final int N =
	 * nums.length; Arrays.sort(nums); return nums[N - k]; }
	 */
	
	public static int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}
