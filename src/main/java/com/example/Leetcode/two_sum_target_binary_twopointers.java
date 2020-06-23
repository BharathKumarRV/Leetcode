package com.example.Leetcode;

public class two_sum_target_binary_twopointers {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 4, 9, 56, 90 };
		int res[] = twoSum(nums,99);
		System.out.println(res[0] + " " + res[1]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                // move end forward to the last value that numbers[end] <= target - numbers[start]
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                // move start backword to the first value that numbers[start] >= target - numbers[end]
                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return new int[2];
    }
    private static int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    private static int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
