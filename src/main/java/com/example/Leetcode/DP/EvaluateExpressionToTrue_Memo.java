package com.example.Leetcode.DP;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrue_Memo {

	public static void main(String args[]) {
		String str = "T^F&T";
		System.out.println("Number of ways for true" + parenthesis_count(str, 0, str.length() - 1, true));
	}
	
	static Map<String,Integer> map=new HashMap<String,Integer>();

	public static int parenthesis_count(String str, int i, int j, boolean isTrue) {
		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == true) {
				return (str.charAt(i) == 'T') ? 1 : 0;
			} else {
				return (str.charAt(i) == 'F') ? 1 : 0;
			}
		}

		String temp=i+" "+j+" "+isTrue;
		
		if(map.containsKey(temp)) {
			return map.get(temp);
		}
		
		int temp_ans = 0;

		int leftTrue, rightTrue, leftFalse, rightFalse;

		for (int k = i + 1; k <= j - 1; k = k + 2) {
			// Count number of True in left Partition
			leftTrue = parenthesis_count(str, i, k - 1, true);

			// Count number of False in left Partition
			leftFalse = parenthesis_count(str, i, k - 1, false);

			// Count number of True in right Partition
			rightTrue = parenthesis_count(str, k + 1, j, true);

			// Count number of False in right Partition
			rightFalse = parenthesis_count(str, k + 1, j, false);
			// Evaluate AND operation
			if (str.charAt(k) == '&') {
				if (isTrue == true) {
					temp_ans = temp_ans + leftTrue * rightTrue;
				} else {
					temp_ans = temp_ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
				}
			}
			// Evaluate OR operation
			else if (str.charAt(k) == '|') {
				if (isTrue == true) {
					temp_ans = temp_ans + leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
				} else {
					temp_ans = temp_ans + leftFalse * rightFalse;
				}
			}

			// Evaluate XOR operation
			else if (str.charAt(k) == '^') {
				if (isTrue == true) {
					temp_ans = temp_ans + leftTrue * rightFalse + leftFalse * rightTrue;
				} else {
					temp_ans = temp_ans + leftTrue * rightTrue + leftFalse * rightFalse;
				}
			}
		}
		map.put(temp, temp_ans);
		return temp_ans;
	}
}
