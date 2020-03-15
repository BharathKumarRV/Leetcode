package com.example.Leetcode;

public class Zig_Zag_Conversion {

	public String convert(String s, int nRows) {
        
        char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuilder[] sb = new StringBuilder[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    return String.join("", sb);
        
    }
}
