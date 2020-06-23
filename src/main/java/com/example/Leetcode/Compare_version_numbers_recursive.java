package com.example.Leetcode;

public class Compare_version_numbers_recursive {

	public static void main(String[] args) {
		int res = compareVersion("7.5.2.4", "7.5.3");
		System.out.println(res);
	}
	
	
	public static int compareVersion(String version1, String version2) {
	    if(version1.equals("") && version2.equals("")) return 0; // both are "", return 0
	    
	    String sub1, sub2;
	    int v1s, v2s;
	    if(version1.equals("")) {
	        v1s = 0;
	        sub1 = "";
	    }
	    else {
	        int id1 = version1.indexOf(".");
	        
	        if(id1==-1) {
	            v1s = Integer.parseInt(version1);
	            sub1 = "";
	        }
	        else {
	            v1s = Integer.parseInt(version1.substring(0, id1));
	            sub1 = version1.substring(id1+1);
	        }
	    }
	    
	    if(version2.equals("")) {
	        v2s = 0;
	        sub2 = "";
	    }
	    else {
	        int id2 = version2.indexOf(".");
	        if(id2==-1) {
	            v2s = Integer.parseInt(version2);
	            sub2 = "";
	        }
	        else {
	            v2s = Integer.parseInt(version2.substring(0, id2));
	            sub2 = version2.substring(id2+1);
	        }
	    }
	    
	    if(v1s>v2s) return 1;
	    if(v1s<v2s) return -1;
	    return compareVersion(sub1, sub2);
	}
}
