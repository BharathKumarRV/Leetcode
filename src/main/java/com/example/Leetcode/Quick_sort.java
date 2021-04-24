package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Quick_sort {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 12, 11, 13, 5, 6, 7 };
		quickSort(nums, 0, nums.length - 1);
		printArray(nums);

	}
	
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	static int partition(int[] arr, int low, int high)
	{
	     
	    // pivot
	    int pivot = arr[high];
	     
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        // If current element is smaller
	        // than the pivot
	        if (arr[j] < pivot)
	        {
	             
	            // Increment index of
	            // smaller element
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	
	static void quickSort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	         
	        // pi is partitioning index, arr[p]
	        // is now at right place
	        int pi = partition(arr, low, high);
	 
	        // Separately sort elements before
	        // partition and after partition
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}
	
	static void printArray(int[] arr)
	{
	    for(int i = 0; i < arr.length; i++)
	        System.out.print(arr[i] + " ");
	         
	    System.out.println();
	}
}
