package com.example.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Contains_duplicates {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[]= {1,2,3,1};
		boolean res = containsDuplicate(nums);
		System.out.println(res);

	}
	
	public static boolean containsDuplicate(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
	
	
	
	/*
	 * public static boolean containsDuplicate(int[] nums) {
	 * 
	 * Arrays.sort(nums); for(int ind = 1; ind < nums.length; ind++) { if(nums[ind]
	 * == nums[ind - 1]) { return true; } } return false; }
	 * 
	 * public static boolean containsDuplicate(int[] nums) {
	 * 
	 * final Set<Integer> distinct = new HashSet<Integer>(); for(int num : nums) {
	 * if(distinct.contains(num)) { return true; } distinct.add(num); } return
	 * false; }
	 */
}
