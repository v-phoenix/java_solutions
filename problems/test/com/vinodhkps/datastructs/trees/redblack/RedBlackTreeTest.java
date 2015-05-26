package com.vinodhkps.datastructs.trees.redblack;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

	RedBlackTree classUnderTest = new RedBlackTree();

	@Test
	public void testLeftRotate() {

		// @formatter:off
		/*
		 
		 Input: Node to be left-rotated: 44
		 
		 		  50
		 		/    \
		  	  44
		  	/   \
		  43     46
		        /  \
		      45    47
		
		 Output:
		 
		 		  50
		 		/    \
		  	  46
		  	/   \
		  44     47
		 /  \
		43  45
		      

     
		 */
		// @formatter:on

		RedBlackNode parent = new RedBlackNode(50);
		RedBlackNode node = new RedBlackNode(44);
		/*- set the node as left child-*/
		node.setParent(parent);
		parent.setLeft(node);

		/*- give it a right child -*/
		RedBlackNode nodesRight = new RedBlackNode(46);
		node.setRight(nodesRight);
		nodesRight.setParent(node);

		/*- give the right node a left child -*/
		RedBlackNode aLeftNode = new RedBlackNode(45);
		aLeftNode.setParent(nodesRight);
		nodesRight.setLeft(aLeftNode);

		/*- give the right node a left child -*/
		RedBlackNode aRightNode = new RedBlackNode(47);
		aRightNode.setParent(nodesRight);
		nodesRight.setRight(aRightNode);

		/*- give the node a left child -*/
		RedBlackNode nodesLeft = new RedBlackNode(43);
		nodesLeft.setParent(node);
		node.setLeft(nodesLeft);

		Assert.assertEquals(Integer.valueOf(46), node.getRight().getData());
		Assert.assertEquals(Integer.valueOf(50), node.getParent().getData());

		classUnderTest.leftRotate(node);

		Assert.assertEquals(Integer.valueOf(45), node.getRight().getData());
		Assert.assertEquals(Integer.valueOf(46), node.getParent().getData());
		Assert.assertEquals(node, node.getParent().getLeft());

	}

	@Test
	public void testRightRotate() {
		// @formatter:off
		/*
		 
		 Input: Node to be right-rotated: 46
		 
		 		  50
		 		/    \
		  	  46
		  	/   \
		  44     47
		 /  \
		43  45
		
		Output:
		
		 
		 		  50
		 		/    \
		  	  44
		  	/   \
		  43     46
		        /  \
		      45    47
		
     
		 */
		// @formatter:on

		RedBlackNode parent = new RedBlackNode(50);
		RedBlackNode node = new RedBlackNode(46);
		/*- set the node as left child-*/
		node.setParent(parent);
		parent.setLeft(node);

		/*- give it a right child -*/
		RedBlackNode nodesRight = new RedBlackNode(47);
		node.setRight(nodesRight);
		nodesRight.setParent(node);

		/*- give the node a left child -*/
		RedBlackNode nodesLeft = new RedBlackNode(44);
		nodesLeft.setParent(node);
		node.setLeft(nodesLeft);

		/*- give the right node a left child -*/
		RedBlackNode aLeftNode = new RedBlackNode(43);
		aLeftNode.setParent(nodesLeft);
		nodesLeft.setLeft(aLeftNode);

		/*- give the right node a left child -*/
		RedBlackNode aRightNode = new RedBlackNode(45);
		aRightNode.setParent(nodesLeft);
		nodesLeft.setRight(aRightNode);

		Assert.assertEquals(Integer.valueOf(44), node.getLeft().getData());
		Assert.assertEquals(Integer.valueOf(50), node.getParent().getData());

		classUnderTest.rightRotate(node);

		Assert.assertEquals(Integer.valueOf(44), node.getParent().getData());
		Assert.assertEquals(Integer.valueOf(45), node.getLeft().getData());
	}

	@Test
	public void testHeight() {
		RedBlackNode parent = new RedBlackNode(50);
		RedBlackNode node = new RedBlackNode(46);
		/*- set the node as left child-*/
		node.setParent(parent);
		parent.setLeft(node);

		/*- give it a right child -*/
		RedBlackNode nodesRight = new RedBlackNode(47);
		node.setRight(nodesRight);
		nodesRight.setParent(node);

		/*- give the node a left child -*/
		RedBlackNode nodesLeft = new RedBlackNode(44);
		nodesLeft.setParent(node);
		node.setLeft(nodesLeft);

		/*- give the right node a left child -*/
		RedBlackNode aLeftNode = new RedBlackNode(43);
		aLeftNode.setParent(nodesLeft);
		nodesLeft.setLeft(aLeftNode);

		/*- give the right node a left child -*/
		RedBlackNode aRightNode = new RedBlackNode(45);
		aRightNode.setParent(nodesLeft);
		nodesLeft.setRight(aRightNode);
		aRightNode.setLeft(classUnderTest.sentinel);
		aRightNode.setRight(classUnderTest.sentinel);

		int actual = classUnderTest.height(parent);
		int expected = 4;

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testInserts() {
		classUnderTest.insert(23);
		classUnderTest.insert(37);
		classUnderTest.insert(45);
		classUnderTest.insert(55);
		classUnderTest.insert(66);
		classUnderTest.insert(12);
		classUnderTest.insert(76);
		classUnderTest.insert(86);
		classUnderTest.insert(95);

		int expected = 4;
		int actual = classUnderTest.height();
		
		Assert.assertEquals(expected, actual);
		classUnderTest.print();
	}
}
