package com.dailycodingproblem;

public class DivisionWithoutOperator {
	public static void main(String[] args) {
		System.out.println(divide(89,7));
	}

	private static int divide(int number, int divider) {
		int quotient=0;
		while(number>=divider) {
			quotient+=1;
			number-=divider;
		}
		
		return quotient;
	}
}
