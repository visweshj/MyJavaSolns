package com.dailycodingproblem;


/**
 * 
 * @author visweshjagadeesan
 * 
 * Invert a binary tree.

		For example, given the following tree:
		
		    a
		   / \
		  b   c
		 / \  /
		d   e f
		should become:
		
		  a
		 / \
		 c  b
		 \  / \
		  f e  d
 *
 */
public class InvertABinaryTree {
	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode('a'), node2 = new BinaryTreeNode('b'),
				node3 = new BinaryTreeNode('c'), node4 = new BinaryTreeNode('d'), node5 = new BinaryTreeNode('e'),
						node6 = new BinaryTreeNode('f');
		
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		node3.setLeftNode(node6);
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		
		printNode(node1);
		invertNodes(node1);
		System.out.println("\nPost Conversion");
		printNode(node1);
		
	}
	
	
private static void printNode(BinaryTreeNode node) {
		
		BinaryTreeNode rightNode = node.rightNode, leftNode=node.leftNode;
		
		System.out.print("\nNode : "+node.getValue() );
		if(leftNode!=null)
			System.out.print("\t: Left: "+leftNode.value);
		if(rightNode!=null)
			System.out.print("\t: Right: "+rightNode.value);
		
		if(leftNode!=null)
				printNode(leftNode);
		if(rightNode!=null)
				printNode(rightNode);
			
		
	}
	
	private static void invertNodes(BinaryTreeNode node) {
		
		BinaryTreeNode rightNode = node.rightNode, leftNode=node.leftNode;
			if(leftNode!=null)
				invertNodes(leftNode);
			if(rightNode!=null)
				invertNodes(rightNode);
			
		node.leftNode=rightNode;
		node.rightNode=leftNode;
	}
}

class BinaryTreeNode{
	
	BinaryTreeNode rightNode, leftNode;
	char value;
	
	
	public BinaryTreeNode(char value) {
		super();
		this.value = value;
	}
	public BinaryTreeNode(BinaryTreeNode rightNode, BinaryTreeNode leftNode, char value) {
		super();
		this.rightNode = rightNode;
		this.leftNode = leftNode;
		this.value = value;
		
	}
	public BinaryTreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	
	
}
