package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Merge_Intervals_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		int[][] res = merge(a);
		for (int i = 0; i < res.length; i++) {
			int temp[] = res[i];
			System.out.println(temp[0] + " " + temp[1]);
		}

	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		List<int[]> result = new ArrayList<>();
		int[] current_Interval = intervals[0];
		result.add(current_Interval);
		for (int[] interval : intervals) {
			int current_begin = current_Interval[0];
			int current_end = current_Interval[1];
			int next_begin = interval[0];
			int next_end = interval[1];

			if (current_end >= next_begin) {
				current_Interval[1] = Math.max(current_end, next_end);
			} else {
				current_Interval = interval;
				result.add(current_Interval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	public static int[][] merge_2(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

		List<int[]> result = new ArrayList<>();

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] i : intervals) {
			if (i[0] <= end) {
				end = Math.max(end, i[1]);
			} else {
				result.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			}
		}

		result.add(new int[] { start, end });
		return result.toArray(new int[0][]);
	}
}
