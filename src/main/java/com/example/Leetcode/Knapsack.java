package com.example.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

class Knapsack {
	class Item {
		int value;
		int weight;

		public Item(int value, int weight) {
			super();
			this.value = value;
			this.weight = weight;
		}

	}

	class itemComparator implements Comparator<Item> {
		@Override
		public int compare(Item a, Item b) {
			double r1 = (double) (a.value) / (double) (a.weight);
			double r2 = (double) (b.value) / (double) (b.weight);
			if (r1 < r2)
				return 1;
			else if (r1 > r2)
				return -1;
			else
				return 0;
		}
	}

	static Knapsack kp=new Knapsack();
	
	public static void main(String arg[]) {
		
		Item arr[]= {kp.new Item(60,10),kp.new Item(100,20),kp.new Item(120,30)};
		double res=fractionalKnapsack(50,arr,3);
		System.out.println(res);
	}
	
		static double fractionalKnapsack(int W, Item arr[], int n) {
			
			Arrays.sort(arr, kp.new itemComparator());

			int curWeight = 0;
			double finalvalue = 0.0;

			for (int i = 0; i < n; i++) {

				if (curWeight + arr[i].weight <= W) {
					curWeight += arr[i].weight;
					finalvalue += arr[i].value;
				}

				else {
					int remain = W - curWeight;
					finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
					break;
				}
			}

			return finalvalue;

		}

}