package com.example.Leetcode;

public class Compare_version_numbers_nosplit {

	public static void main(String[] args) {
		int res = compareVersion("7.5.2.4", "7.5.3");
		System.out.println(res);
	}

	public static int compareVersion(String version1, String version2) {
		int temp1 = 0, temp2 = 0;
		int len1 = version1.length(), len2 = version2.length();
		int i = 0, j = 0;
		while (i < len1 || j < len2) {
			temp1 = 0;
			temp2 = 0;
			while (i < len1 && version1.charAt(i) != '.') {
				temp1 = temp1 * 10 + version1.charAt(i++) - '0';

			}
			while (j < len2 && version2.charAt(j) != '.') {
				temp2 = temp2 * 10 + version2.charAt(j++) - '0';

			}
			if (temp1 > temp2)
				return 1;
			else if (temp1 < temp2)
				return -1;
			else {
				i++;
				j++;

			}

		}
		return 0;
	}

}
