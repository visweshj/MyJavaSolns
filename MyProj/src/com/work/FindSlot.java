package com.work;

import java.util.*;

public class FindSlot {

	public static void main(String[] args) {
		
		List<List<Integer>> lot = new ArrayList<>();
		List<Integer> locn1 = new ArrayList<>();
		List<Integer> locn2 = new ArrayList<>();
		List<Integer> locn3 = new ArrayList<>();
		
		locn1.add(1);
		locn1.add(1);
		locn1.add(1);
		
		locn2.add(0);
		locn2.add(0);
		locn2.add(1);
		
		locn3.add(1);
		locn3.add(9);
		locn3.add(1);
		
		lot.add(locn1);
		lot.add(locn2);
		lot.add(locn3);
		
		
		
		
		int ret =removeObstacle(3, 3, lot );
		System.out.println("Shortest Distance :"+ret);
		
	}
	
	static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
		
		// Setting the source
		Point source = new Point(0, 0, 0);
		boolean visitedCells[][] = new boolean[numRows][numColumns];
		
		for(int row=0; row<numRows; row++) {
			for(int col=0; col<numColumns; col++) {
				visitedCells[row][col] = lot.get(row).get(col)==0;
			}
		}
		
		Queue<Point> traversalQ = new LinkedList<>();
		traversalQ.add(source);
		visitedCells[source.row][source.col] = true;
		
		while(!traversalQ.isEmpty()) {
			Point p =traversalQ.element();
			traversalQ.remove();
			
			// Found 9
			if(lot.get(p.getRow()).get(p.getCol()) == 9) {
				return p.getDist();
			}
			
			// moving up
			if(p.getRow()-1>=0 && !visitedCells[p.getRow()-1][p.getCol()]) {
				traversalQ.add(new Point(p.getRow()-1, p.getCol(), p.getDist()+1 ));
				visitedCells[p.getRow()-1][p.getCol()] = true;
			}
			
			
			// moving down
			if(p.getRow()+1<numRows  && !visitedCells[p.getRow()+1][p.getCol()]) {
				traversalQ.add(new Point(p.getRow()+1, p.getCol(), p.getDist()+1 ));
				visitedCells[p.getRow()+1][p.getCol()] = true;
			}
			
			
			// moving left
			if(p.getCol()-1>=0 && !visitedCells[p.getRow()][p.getCol()-1]) {
				traversalQ.add(new Point(p.getRow(), p.getCol()-1, p.getDist()+1 ));
				visitedCells[p.getRow()][p.getCol()-1] = true;
			}
						
						
			// moving right
			if(p.getCol()+1<numColumns  && !visitedCells[p.getRow()][p.getCol()+1]) {
				traversalQ.add(new Point(p.getRow(), p.getCol()+1, p.getDist()+1 ));
				visitedCells[p.getRow()][p.getCol()+1] = true;
			}
			
			
		}
		
		return -1;
    }
	

}
class Point{
	int row;
	int col;
	int dist;
	
	public Point() {
		
	}
	
	public Point(int row, int col, int dist) {
		this.row=row;
		this.col=col;
		this.dist=dist;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}
}


