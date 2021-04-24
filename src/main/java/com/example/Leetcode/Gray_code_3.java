package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Gray_code_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		Gray_code_3 obj = new Gray_code_3();
		List<String> res = obj.grayCode(3);
		System.out.print(res);

	}

	// List<String> list = new ArrayList<String>();

	public List<String> grayCode(int n) {

		if (n == 1) {
			List<String> bres = new ArrayList<String>();
			bres.add("0");
			bres.add("1");
			return bres;
		}
		List<String> res = grayCode(n - 1);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < res.size(); i++) {
			String resnum = res.get(i);
			String restr = "0" + resnum;
			list.add(restr);
		}

		for (int i = res.size() - 1; i >= 0; i--) {
			String resnum = res.get(i);
			String restr = "1" + resnum;
			list.add(restr);
		}

		return list;
	}

}
