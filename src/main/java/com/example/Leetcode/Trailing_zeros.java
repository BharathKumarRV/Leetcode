package com.example.Leetcode;

public class Trailing_zeros {

	public static void main(String[] args) {
		int res = trailingZeroes(10);
		System.out.println(res);

	}

	public static int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {  //10/5,10/5^2
			int tmp = n / 5;
			count += tmp;
			n = tmp;
		}
		return count;
	}
	
	public static int trailingZeroes_4(int n) {
		int ans=0;
		int p=5;
		while (n/p>0) {
			ans+= n/p;
			p=p*5;    //divide by 25 means, checking for two 5's.
		}
		return ans;
	}

	public static int trailingZeroes_2(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static int trailingZeroes_3(int n) {
		if (n < 5)
			return 0;
		else
			return (n / 5) + trailingZeroes(n / 5);
	}

}
