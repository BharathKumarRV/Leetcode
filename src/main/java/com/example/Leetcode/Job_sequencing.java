package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

public class Job_sequencing {

	class Job {
		private int profit;

		private int deadline;

		public Job(int profit, int deadline) {
			super();
			this.profit = profit;
			this.deadline = deadline;
		}

	}

	public static void main(String args[]) {
		int deadline[] = { 2, 1, 2, 1, 1 };
		int profit[] = { 100, 19, 27, 25, 15 };
		Job_sequencing js=new Job_sequencing();
		Job arr[]=new Job[deadline.length];
		for(int i=0;i<deadline.length;i++) {
			arr[i]=js.new Job(profit[i],deadline[i]);
		}
		int ans[] = JobScheduling(arr, deadline.length);
		System.out.println(ans[0]+" "+ans[1]);
	}

	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		int maxi = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxi) {
				maxi = arr[i].deadline;
			}
		}

		int result[] = new int[maxi + 1];

		for (int i = 1; i <= maxi; i++) {
			result[i] = -1;
		}

		int countJobs = 0, jobProfit = 0;

		for (int i = 0; i < n; i++) {

			for (int j = arr[i].deadline; j > 0; j--) {

				// Free slot found
				if (result[j] == -1) {
					result[j] = i;
					countJobs++;
					jobProfit += arr[i].profit;
					break;
				}
			}
		}

		int ans[] = new int[2];
		ans[0] = countJobs;
		ans[1] = jobProfit;
		return ans;

	}
}
