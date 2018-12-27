package com.dailycodingproblem;
import java.util.*;

/**
 * 
 * @author visweshjagadeesan
 * Given k sorted singly linked lists, 
 * write a function to merge all the lists into one sorted singly linked list.
 */
public class MergeSortedLinkedLists {
	public static void main(String[] args) {
		
		List<LinkedList<Integer>> inputs = new ArrayList<>();
	    
		LinkedList<Integer> list1 = new LinkedList<Integer>(1);  
		list1.next = new LinkedList<Integer>(3);  
		list1.next.next = new LinkedList<Integer>(5);  
		list1.next.next.next = new LinkedList<Integer>(7);  
    
		LinkedList<Integer> list2 = new LinkedList<Integer>(2);  
		list2.next = new LinkedList<Integer>(4);  
		list2.next.next = new LinkedList<Integer>(6);  
		list2.next.next.next = new LinkedList<Integer>(8);  
    
        LinkedList<Integer> list3 = new LinkedList<Integer>(0);  
        list3.next = new LinkedList<Integer>(9);  
        list3.next.next = new LinkedList<Integer>(10);  
        list3.next.next.next = new LinkedList<Integer>(11);  
        list3.next.next.next.next = new LinkedList<Integer>(112);  
        inputs.add(list1);
        inputs.add(list2);
        inputs.add(list3);
        
        LinkedList<Integer> result = mergeLinkedLists(inputs);
        
        while(result!=null) {
        	System.out.println(result.value);
        	result = result.next;
        }
        
        
	}
	
	private static LinkedList<Integer> mergeLinkedLists(List<LinkedList<Integer>> inputs){
		
		PriorityQueue<LinkedList<Integer>> pq = new PriorityQueue<>((l1,l2)-> (((Integer)l1.value).compareTo((Integer)l2.value)));
		
		
		LinkedList<Integer> head = new LinkedList<>(0);
		LinkedList<Integer> p=head;
		
		for(LinkedList<Integer> linkdList : inputs) {
			if(linkdList!=null) {
				pq.offer(linkdList);
			}
		}
		
		
		while(!pq.isEmpty()) {
			LinkedList<Integer> node = pq.poll();
			p.next=node;
			p=p.next;
				
			if(node.next!=null) {
				pq.offer(node.next);
			}
		}
		
		
		return head.next;
	}
	
}
class LinkedList<T> implements Comparable<T>{
	T value;
	LinkedList<T> next;
	
	LinkedList(T value){
		this.value = value;
	}
	
	public LinkedList(T value, LinkedList<T> next) {
		super();
		this.value = value;
		this.next = next;
	}

	@Override
	public int compareTo(T o) {
		
		return ((Integer)o).compareTo((Integer)value);
	}

	
	
}