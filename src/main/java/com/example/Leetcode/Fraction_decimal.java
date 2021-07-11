package com.example.Leetcode;

import java.util.HashMap;

public class Fraction_decimal {

	public static void main(String[] args) {
		String res = fractionToDecimal(47, 18);
		System.out.println(res);
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		// "+" or "-"
		res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		// integral part
		long q = num / den;
		long rem = num % den;
		res.append(q);
		if (rem == 0) {
			return res.toString();
		}

		// fractional part
		res.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while (rem != 0) {
			if (map.containsKey(rem)) {
				int index = map.get(rem);
				res.insert(index, "(");
				res.append(")");
				break;
			} else {
				map.put(rem, res.length());
				rem *= 10;
				q = rem / den;
				rem = rem % den;
				res.append(q);
			}
		}
		return res.toString();
	}
}
