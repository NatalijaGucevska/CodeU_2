import java.util.ArrayList;

public class BinaryTree<T> {
	Node<T> root;

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	public boolean add(Node<T> current, Node<T> left, Node<T> right) {
		if (current != null) {
			current.setLeft(left);
			current.setRight(right);
			if (left != null) {
				if (left.getParent() != null) {
					return false;
				}
				left.setParent(current);
			}
			if (right != null) {
				if (right.getParent() != null) {
					return false;
				}
				right.setParent(current);
			}
			return true;
		}
		return false;
	}
}
