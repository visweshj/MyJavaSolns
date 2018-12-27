package com.dailycodingproblem;


/**
 * @author visweshjagadeesan
 * Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.
 * The input list is not necessarily ordered in any way.
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 *
 */
public class MergeOverlappingIntervals {
	
	

}


class Interval{
	int start;
	int end;
	
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	public boolean isWithin(Interval slot) {
		return false;
	}	
	
	
}