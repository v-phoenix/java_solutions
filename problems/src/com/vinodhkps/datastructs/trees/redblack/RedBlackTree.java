package com.vinodhkps.datastructs.trees.redblack;

import static com.vinodhkps.util.MathUtil.max;

public class RedBlackTree {

	RedBlackNode sentinel;
	RedBlackNode root;

	public RedBlackTree() {
		super();
		initSentinel();
		root = sentinel;
	}

	private void initSentinel() {
		sentinel = new RedBlackNode(null);
		sentinel.setColor(NodeColor.Black);
		sentinel.setRight(null);
		sentinel.setLeft(null);
		sentinel.setParent(null);
	}

	/**
	 * Inserts the given data to the tree and then balances the height of the
	 * tree.
	 * 
	 * @param data
	 */
	public void insert(Integer data) {
		RedBlackNode x = root;
		RedBlackNode y = sentinel;

		/*- find the parent -*/
		while (!x.equals(sentinel)) {
			y = x;
			if (x.getData() < data) {
				x = x.getRight();
			} else {
				x = x.getLeft();
			}
		}

		/*- attach the node to the tree -*/
		RedBlackNode nodeToInsert = aLeafNodeWithRedColor(data);
		nodeToInsert.setParent(y);
		if (y.equals(sentinel)) {
			root = nodeToInsert;
		} else if (y.getData() > data) {
			y.setLeft(nodeToInsert);
		} else {
			y.setRight(nodeToInsert);
		}

		/*- balance the tree -*/
		redBlackFixUpInsert(nodeToInsert);
	}

	void redBlackFixUpInsert(RedBlackNode node) {
		while (node.getParent().getColor() == NodeColor.Red) {
			if (node.getParent().equals(node.getParent().getParent().getLeft())) {
				RedBlackNode y = node.getParent().getParent().getRight();
				if (y.getColor() == NodeColor.Red) {
					node.getParent().setColor(NodeColor.Black);
					y.setColor(NodeColor.Black);
					node.getParent().getParent().setColor(NodeColor.Red);
					node = node.getParent().getParent();
				} else {
					if (node.equals(node.getParent().getRight())) {
						node = node.getParent();
						leftRotate(node);
					}
					node.getParent().setColor(NodeColor.Black);
					node.getParent().getParent().setColor(NodeColor.Red);
					rightRotate(node.getParent().getParent());
				}
			} else {
				RedBlackNode y = node.getParent().getParent().getLeft();
				if (y.getColor() == NodeColor.Red) {
					node.getParent().setColor(NodeColor.Black);
					y.setColor(NodeColor.Black);
					node.getParent().getParent().setColor(NodeColor.Red);
					node = node.getParent().getParent();
				} else {
					if (node.equals(node.getParent().getLeft())) {
						node = node.getParent();
						rightRotate(node);
					}
					node.getParent().setColor(NodeColor.Black);
					node.getParent().getParent().setColor(NodeColor.Red);
					leftRotate(node.getParent().getParent());
				}
			}
		}

		this.root.setColor(NodeColor.Black);
	}

	RedBlackNode aLeafNodeWithRedColor(Integer data) {
		RedBlackNode node = new RedBlackNode(data);
		node.setLeft(sentinel);
		node.setRight(sentinel);
		node.setParent(sentinel);
		node.setColor(NodeColor.Red);
		return node;
	}

	public int height() {
		return height(root);
	}

	int height(RedBlackNode node) {
		int ret = 0;
		if (node != null && !node.equals(sentinel)) {
			ret = max(height(node.getLeft()), height(node.getRight())) + 1;
		}
		return ret;
	}

	void leftRotate(RedBlackNode node) {
		if (node.getRight() == null) {
			System.err
					.println("Cannot Left Rotate a Node whose Right Child is Null");
			return;
		}
		RedBlackNode y = node.getRight();

		node.setRight(y.getLeft());

		if (!y.getLeft().equals(sentinel)) {
			y.getLeft().setParent(node);
		}

		if (node.getParent().equals(sentinel)) {
			// root
			this.root = y;
		} else if (node.getParent().getLeft().equals(node)) {
			node.getParent().setLeft(y);
		} else {
			node.getParent().setRight(y);
		}
		y.setParent(node.getParent());
		y.setLeft(node);
		node.setParent(y);
	}

	void rightRotate(RedBlackNode node) {
		if (node.getLeft() == null) {
			System.err
					.println("Cannot Left Rotate a Node whose Left Child is Null");
			return;
		}
		RedBlackNode y = node.getLeft();

		node.setLeft(y.getRight());

		if (!y.getRight().equals(sentinel)) {
			y.getRight().setParent(node);
		}

		if (node.getParent().equals(sentinel)) {
			// root
			this.root = y;
		} else if (node.getParent().getLeft().equals(node)) {
			node.getParent().setLeft(y);
		} else {
			node.getParent().setRight(y);
		}
		y.setParent(node.getParent());
		y.setRight(node);
		node.setParent(y);
	}

	public void print() {
		print(root, 0);
	}

	void print(RedBlackNode node, int level) {
		if (!node.equals(sentinel)) {
			System.out.println(node.toString()+" level "+level);
			StringBuffer branches = new StringBuffer();
			if (!node.getLeft().equals(sentinel))
				branches.append("/");
			if (!node.getRight().equals(sentinel))
				branches.append("\\");
			System.out.println(branches.toString());
			print(node.getLeft(), level+1);
			print(node.getRight(), level+1);
		}
	}

}
