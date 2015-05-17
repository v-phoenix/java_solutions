package com.vinodhkps.datastructs.trees;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

	BinarySearchTree<Integer> classUnderTest = new BinarySearchTree<Integer>();

	@Test
	public void testInsert() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(23);
		classUnderTest.insert(node);

		Assert.assertTrue(node.equals(classUnderTest.getRoot()));

		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(35);

		classUnderTest.insert(node1);
		classUnderTest.insert(node2);

		Assert.assertTrue(node1.equals(classUnderTest.getRoot().getLeft()));
		Assert.assertTrue(node2.equals(classUnderTest.getRoot().getRight()));
		
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(15);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(27);
		
		classUnderTest.insert(node3);
		classUnderTest.insert(node4);
		
		Assert.assertTrue(node1.getRight().equals(node3));
		Assert.assertTrue(node2.getLeft().equals(node4));
		
		System.out.print("\nTest Insertion.");
		classUnderTest.inOrder();

	}

	@Test
	public void testDelete() {
		
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(23);
		classUnderTest.insert(node);

		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(35);

		classUnderTest.insert(node1);
		classUnderTest.insert(node2);

		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(15);
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(27);
		
		classUnderTest.insert(node3);
		classUnderTest.insert(node4);
		
		System.out.print("In Order Traversal Before Deletion of Node 3 "+node3);
		
		classUnderTest.inOrder();
		
		classUnderTest.delete(node3);
		
		System.out.print("\nIn Order Traversal After Deletion of Node 3 "+node3);
		
		classUnderTest.inOrder();
		
		Assert.assertTrue(node.getLeft().equals(node1));
		
		System.out.print("\nIn Order Traversal Before Deletion of Node  "+node);
		classUnderTest.inOrder();
		
		classUnderTest.delete(node);
		
		System.out.print("\nIn Order Traversal After Deletion of Node  "+node);
		classUnderTest.inOrder();

	}

}
