package com.dailycodingproblem;

/**
 * 
 * @author visweshjagadeesan
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring and 
 * their perimeter is surrounded by water.

 * For example, this matrix has 4 islands.

	1 0 0 0 0
	0 0 1 1 0
	0 1 1 0 0
	0 0 0 0 0
	1 1 0 0 1
	1 1 0 0 1
 *
 */

public class NoOfIslands {
	public static void main(String[] args) {
		int[][] input = {{1, 0, 0, 0, 0}, 
						 {0, 0, 1, 1, 0}, 
						 {0, 1, 1, 0, 0},
						 {0, 0, 0, 0, 0},
						 {1, 1, 0, 0, 1},
						 {1, 1, 0, 0, 1}};
		
		System.out.println(findNofOfIslands(input));
	}
	
	 private static int findNofOfIslands(int[][] input) {
		int noOfIslands =0;
		
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[row].length; col++) {
				int val = input[row][col];
				if(val==1) {
					noOfIslands++;
					voidTheIsland(input, row, col );
				}
				
				
			}
			
		}
		return noOfIslands;
	}
	private static void voidTheIsland(int[][] input, int row, int col) {
		if(row< 0 || col< 0 || row >= input.length || col >= input[row].length) {
			return;
		}
		if(input[row][col]==0) {
			return;
		}
		
		input[row][col]=0;
		for(int r=row-1; r<=row+1; r++) {
			for(int c=col-1; c<=col+1; c++) {
				voidTheIsland(input, r, c);
			}
		}
		
	}
	
	
}
