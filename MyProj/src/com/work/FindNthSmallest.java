package com.work;

import java.util.stream.IntStream;

public class FindNthSmallest {
	public static void main(String[] args) {
		int [] input = {12, 3, 5, 7, 4, 19, 26};
		
		int rstl = findNthSmallest(input, 7);
		
			IntStream.of(input)
			.sorted()
			.limit(3);
		
		System.out.println(rstl== 26);
		
	}
	
	private static int findNthSmallest(int[] input , int m) {
		int[] op = new int[input.length];
		int fwd =1, bkwd=1;
		op[m-1]=input[0];
		for(int i=1; i<input.length; i++) {
			if(input[i]<op[m-1]) {
				if(m-1-bkwd>-1) {
					op[m-1-bkwd]= input[i];
					bkwd++;
				}else {
					op[m-1+fwd]= op[m-1];
					op[m-1]=input[i];
				}
			}else{
				System.out.println(m-1+fwd);
				op[m-1+fwd]= input[i];
				fwd++;
				
			}
			
		}
		
		int max=op[0];
		for(int i=1; i< m-1; i++) {
			if(max<op[i]) {
				max=op[i];
			}
		}
		
		return max;
	}
}
