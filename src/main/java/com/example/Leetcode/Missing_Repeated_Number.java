package com.example.Leetcode;

import java.util.Arrays;

public class Missing_Repeated_Number {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3 };
		int res[] = find_missing_repeating_2(array);
		System.out.println("Missing Element is " + res[0] + "Repeated element" + res[1]);
	}

	private static int[] find_missing_repeating(int[] array) {
		int n = array.length + 1;

		int freq[] = new int[n];
		Arrays.fill(freq, 0);

		int[] res = new int[2];

		for (int i = 0; i < array.length; i++) {
			freq[array[i]]++;
		}

		for (int i = 1; i <=array.length; i++) {
			if (freq[i] == 0) {
				res[0] = i;
			} else if (freq[i] > 1) {
				res[1] = i;
			}
		}

		return res;
	}
	
	private static int[] find_missing_repeating_2(int[] array) {
	    long len = array.length;

	    long S = (len * (len+1) ) /2;
	    long P = (len * (len +1) *(2*len +1) )/6;
	    long missingNumber=0, repeating=0;
	     
	    for(int i=0;i<array.length; i++){
	       S -= (long )array[i];
	       P -= (long)array[i]*(long)array[i];
	    }
	     
	    missingNumber = (S + P/S)/2;

	    repeating = missingNumber - S;

	    int ans[]=new int[2];

	    ans[0]=(int) missingNumber;
	    ans[1]=(int) repeating;

	    return ans;
	}
}
