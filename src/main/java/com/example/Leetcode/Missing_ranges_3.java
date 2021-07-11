package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Missing_ranges_3 {

	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 50, 75 };
		List<String> res = findMissingRanges(array, 0, 99);
		System.out.println(res);
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<String>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>lower) {
                if(nums[i]-lower == 1){
                    ranges.add(lower+"");
                } else {
                    ranges.add(lower + "->" + (nums[i]-1));
                }
            }
            
            if(nums[i]==Integer.MAX_VALUE)
                return ranges;
            
            lower = nums[i] + 1;
        }
        
        if(lower<upper) {
            ranges.add(lower + "->" + upper);
        } else if(lower==upper) {
            ranges.add(lower+"");
        }
        
        return ranges;
    }
}
