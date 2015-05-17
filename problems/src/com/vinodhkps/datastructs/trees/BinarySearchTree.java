package com.vinodhkps.datastructs.trees;

public class BinarySearchTree<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Inserts the specified node in the tree such that the binary search
	 * property is maintained. Takes O(h) time where h is the height of the tree
	 * 
	 * @param node
	 */
	public void insert(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> y = null;
		BinaryTreeNode<T> x = root;

		while (x != null) {
			y = x;
			if (node.getData().compareTo(x.getData()) < 0) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}

		if (y == null) {
			// node being inserted to be marked as the root
			this.root = node;
		} else if (node.getData().compareTo(y.getData()) < 0) {
			y.setLeft(node);
		} else {
			y.setRight(node);
		}
		node.setParent(y);
	}

	public void inOrder() {
		System.out.println("\nPrinting In Order.");
		inOrder(root);
	}

	private void inOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			String prefix = node == root ? "<R>" : "";
			System.out.print(prefix
					+ (node.getData() != null ? node.getData() : "") + "\t");
			inOrder(node.getRight());
		}
	}

	public BinaryTreeNode<T> search(T data) {

		BinaryTreeNode<T> node = root;
		if (data != null && node != null) {
			while (node != null) {
				if (node.getData().compareTo(data) == 0) {
					break;
				} else if (node.getData().compareTo(data) > 0) {
					node = node.getLeft();
				} else {
					node = node.getRight();
				}
			}
		}

		return node;

	}

	/**
	 * Deletes the specified binary node from the tree such that the binary
	 * search tree property is still maintained
	 * 
	 * @param node
	 * @throws IllegalArgumentException
	 *             when the specified node is <code>null</code> or the data in
	 *             the specified node is <code>null</null>
	 */
	public void delete(BinaryTreeNode<T> node) throws IllegalArgumentException {
		if (node == null || node.getData() == null) {
			throw new IllegalArgumentException("Cannot delete a null node!");
		}
		
		node = search(node.getData());
		
		if (node.getLeft() == null) {
			transplant(node, node.getRight());
		} else if (node.getRight() == null) {
			transplant(node, node.getLeft());
		} else {
			BinaryTreeNode<T> successor = minimum(node.getRight());
			if (!successor.getParent().equals(node)) {
				transplant(successor, successor.getRight());
				successor.setRight(node.getRight());
				successor.getRight().setParent(successor);
			}
			transplant(node, successor);
			successor.setLeft(node.getLeft());
			successor.getLeft().setParent(node.getParent());
		}

	}

	/**
	 * Replaces the subtree rooted at node1 with subtree rooted at node2.
	 *
	 * Its the caller's responsibility to handle the left and right children of
	 * both node1 and node2
	 *
	 * @param node1
	 * @param node2
	 */
	void transplant(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {

		if (node1.getParent() == null) {
			root = node2;
		} else if (node1.equals(node1.getParent().getLeft())) {
			node1.getParent().setLeft(node2);
		} else {
			node1.getParent().setRight(node2);
		}
		if (node2 != null) {
			node2.setParent(node1.getParent());
		}
	}

	/**
	 * Returns the node with the minimum data value of the subtree rooted at the
	 * specified input parameter node
	 * 
	 * @param node
	 * @return
	 */
	BinaryTreeNode<T> minimum(BinaryTreeNode<T> node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	/**
	 * Returns the node with the maximum data value of the subtree rooted at the
	 * specified input parameter node
	 * 
	 * @param node
	 * @return
	 */
	BinaryTreeNode<T> maximum(BinaryTreeNode<T> node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}

}
