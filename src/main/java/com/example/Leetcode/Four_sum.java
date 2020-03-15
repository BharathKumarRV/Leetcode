package com.example.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Four_sum {
	
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); int nums[]= {1, 0, -1, 0, -2, 2};
	 * List<List<Integer>> res = la.fourSum(nums,0); System.out.println(res);
	 * 
	 * }
	 */
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(nums[i]*4>target) break;// Too Big!!, it means any 4 numbers behind nums[low] are unable to sum up to target, because they are too large.
            if(nums[i]+3*nums[nums.length-1]<target) continue;//Too Small, it means all numbers are too small.
            
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                
                if(nums[j]*3>target-nums[i]) break;//Too Big
                if(nums[j]+2*nums[nums.length-1]<target-nums[i]) continue;// Too Small
                
                int begin=j+1;
                int end=nums.length-1;
                while(begin<end){
                    int sum=nums[i]+nums[j]+nums[begin]+nums[end];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[begin],nums[end]));
                        while(begin<end && nums[begin]==nums[begin+1]){begin++;}
                        while(begin<end && nums[end]==nums[end-1]){end--;}
                        begin++;
                        end--;
                    }else if (sum<target){
                        begin++;
                    }else{
                        end--;
                    }
                }
            }
        }
    return res;
    }
}
