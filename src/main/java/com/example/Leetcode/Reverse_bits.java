package com.example.Leetcode;

public class Reverse_bits {

	public static void main(String[] args) {

		int res = reverseBits(14);
		System.out.print(res);

	}

	public static int reverseBits(int n) {
		if (n == 0)
			return 0;

		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			if ((n & 1) == 1)
				result++;
			n >>= 1;
		}
		return result;
	}
}