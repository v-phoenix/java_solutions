package com.vinodhkps.datastructs.trees.redblack;

public class RedBlackNode {

	private final Integer data;
	private RedBlackNode parent;
	private RedBlackNode left;
	private RedBlackNode right;
	private NodeColor color;

	public RedBlackNode(Integer data) {
		super();
		this.data = data;
	}

	public RedBlackNode getParent() {
		return parent;
	}

	void setParent(RedBlackNode parent) {
		this.parent = parent;
	}

	public RedBlackNode getLeft() {
		return left;
	}

	void setLeft(RedBlackNode left) {
		this.left = left;
	}

	public RedBlackNode getRight() {
		return right;
	}

	void setRight(RedBlackNode right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public NodeColor getColor() {
		return color;
	}

	void setColor(NodeColor color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedBlackNode other = (RedBlackNode) obj;
		if (color != other.color)
			return false;
		if (data != other.data)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return data + "[" + color + "]";
	}

}
