package com.dailycodingproblem;

/**
 * 
 * @author visweshjagadeesan
 * 
 * Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed 
 * to make the string valid (i.e. each open parenthesis is eventually closed).
 * For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, 
 * since we must remove all of them.
 *
 */
public class RemoveParanthesisToValid {
	
	public static void main(String[] args) {
		System.out.println(noOfInvalidParanthesis(")("));
	}
	
	public static int noOfInvalidParanthesis(String input) {
		int opening=0, closing=0; 
		
		char[] ipChars =input.toCharArray();
		
		for (int i = 0; i < ipChars.length; i++) {
			char c = ipChars[i];
			if(c=='(') {
				opening++;
			}else {
				if(opening>0) {
					opening--;
				}else {
					closing++;
				}
			}
			
		}
		
		return opening+closing;
	}

}
