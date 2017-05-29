public class Node<T> {
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	T val;

	Node(T val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	void setParent(Node<T> parent) {
		this.parent = parent;
	}

	void setLeft(Node<T> left) {
		this.left = left;
	}

	void setRight(Node<T> right) {
		this.right = right;
	}

	Node<T> getParent() {
		return this.parent;
	}

	Node<T> getLeft() {
		return this.left;
	}

	Node<T> getRight() {
		return this.right;
	}

	T getVal() {
		return this.val;
	}

}