package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Insert_interval {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 3 }, { 6, 9 } };
		int[] b = { 2, 5 };
		int[][] res = insert(a, b);
		for (int i = 0; i < res.length; i++) {
			int temp[] = res[i];
			System.out.println(temp[0] + " " + temp[1]);
		}

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int start = newInterval[0];
		int end = newInterval[1];
		List<int[]> list = new ArrayList<>();
		for (int[] interval : intervals) {
			int curStart = interval[0];
			int curEnd = interval[1];
			if (curEnd < start) {
				list.add(new int[] { curStart, curEnd });
			} else if (curStart > end) {
				list.add(new int[] { start, end });
				start = curStart;
				end = curEnd;
			} else {
				start = Math.min(start, curStart);
				end = Math.max(end, curEnd);
			}
		}
		list.add(new int[] { start, end });
		/*
		 * int[][] res = new int[list.size()][2]; for (int i = 0; i < list.size(); i++)
		 * { res[i][0] = list.get(i)[0]; res[i][1] = list.get(i)[1]; } return res;
		 */

		return list.toArray(new int[list.size()][2]);
	}

	public static int[][] insert_2(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList();
		int i = 0, n = intervals.length;
		while (i < n && intervals[i][1] < newInterval[0])
			result.add(intervals[i++]);

		int[] mI = newInterval;
		while (i < n && intervals[i][0] <= newInterval[1]) {
			mI[0] = Math.min(mI[0], intervals[i][0]);
			mI[1] = Math.max(mI[1], intervals[i++][1]);
		}
		result.add(mI);

		while (i < n)
			result.add(intervals[i++]);

		return result.toArray(new int[result.size()][2]);
	}

}
