package com.vinodhkps.datastructs.trees;

class BinaryTreeNode<T extends Comparable<T>> {

	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode<T> parent;

	public BinaryTreeNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		BinaryTreeNode<?> other = (BinaryTreeNode<?>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
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
		return "BinaryTreeNode [data=" + data + "]";
	}
	
	

}
