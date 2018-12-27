package com.dailycodingproblem;

/**
 * @author viswesh jagadeesan
 * 
 * Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

	For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

	Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.
 */
public class NonDecreasingArray {
	
	public static void main(String[] args) {
		int[] input ={1,5,7,31};
		System.out.println(isNonDecreasingArray(input ));
	}
	private static boolean isNonDecreasingArray(int[] input) {
		
		return countNonDecreasingOccurances(input)<2;
	}
	private static int countNonDecreasingOccurances(int[] input) {
		int anamolies=0;
		int prev=input[0];
		
		
		for (int i = 1; i < input.length; i++) {
			int curr = input[i];
			if(curr<prev) {
				anamolies++;
			}
			if(anamolies>1)
				break;
			
			prev=curr;
			
		}
		return anamolies;
	}
}
