package com.dailycodingproblem;


/**
 * @author visweshjagadeesan
 * Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

		    a
		   / \
		  b   c
		 /
		d
 *
 */
public class FindDeepestNode {
	
	int deepestlevel;
	char value;

	public char Deep(BinaryTreeNode root) {
		find(root, 0);
		return value;
	}

	public void find(BinaryTreeNode root, int level) {
		if (root != null) {
			find(root.leftNode, ++level);
			if (level > deepestlevel) {
				value = root.value;
				deepestlevel = level;
			}
			find(root.rightNode, level);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode node1 = new BinaryTreeNode('a'), 
				node2 = new BinaryTreeNode('b'),
				node3 = new BinaryTreeNode('c'), 
				node4 = new BinaryTreeNode('d');
		
		node2.setLeftNode(node4);
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		System.out.println(new FindDeepestNode().Deep(node1));
		
		
		
		
	}
}
