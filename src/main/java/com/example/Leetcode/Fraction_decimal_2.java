package com.example.Leetcode;

import java.util.HashMap;

public class Fraction_decimal_2 {

	public static void main(String[] args) {
		String res = fractionToDecimal(22, 7);
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
		res.append(num / den);
		long remainder = num % den;
		if (remainder == 0) {
			return res.toString();
		}

		// fractional part
		res.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while (num != 0) {
			map.put(num, res.length());

			num *= 10;
			res.append(num / den);
			num %= den;

			Integer remainderIndex = map.get(num);
			if (remainderIndex != null) {
				res.insert(remainderIndex, "(");
				res.append(")");
				break;
			}
		}
		return res.toString();
	}

}
