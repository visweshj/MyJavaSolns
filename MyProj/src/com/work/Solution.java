package com.work;

import java.util.Iterator;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
	public static void main(String[] args) {
		int states[] ={2,3,4,5,6};
		//List<Integer> rst = new Solution().cellCompete(states, 2);
		//rst.forEach(System.out::println);
		System.out.println(new Solution().generalizedGCD(5, states));
		
		
	}
	
	static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    }
	
	
	public int generalizedGCD(int num, int[] arr)
    {	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
			
		}
		int result = arr[0]; 
        for (int i = 1; i < num; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    }
	
	
// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public List<Integer> cellCompete(int[] states, int days)
 {
 
	 for(int day=0; day<days; day++) {
		 int prev=0,next=0;
		 for (int i = 0; i < states.length; i++) {
			int cellState = states[i];
			if(i==0) {
				prev=0;
			}
			if(i==states.length-1) {
				next=0;
			}else {
				next = states[i+1];
			}
			if(prev==next)
				states[i]=0;
			else
				states[i]=1;
			
			prev=cellState;
			
		}
		 
	 }
	 
	 
	 return  IntStream.of(states).boxed().collect(Collectors.toList());
	 
	 // WRITE YOUR CODE HERE
 }
// METHOD SIGNATURE ENDS
}
