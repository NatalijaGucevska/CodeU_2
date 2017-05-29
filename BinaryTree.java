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

	public void printAncestors(T val) {
		ArrayList<Node<T>> ancestors = findAncestors(val);
		for (Node<T> a : ancestors) {
			System.out.print(a.getVal() + " ");
		}
	}

	private ArrayList<Node<T>> findAncestors(T val) {
		Node<T> node = findNode(root.getLeft(), root.getRight(), val);
		ArrayList<Node<T>> ancestors = new ArrayList<>();
		while (node != null && node.getParent() != null) {
			node = node.getParent();
			ancestors.add(node);
		}
		return ancestors;
	}

	private Node<T> findNode(Node<T> left, Node<T> right, T val) {
		if (left != null) {
			if (left.getVal().equals(val)) {
				return left;
			} else {
				Node<T> l = findNode(left.getLeft(), left.getRight(), val);
				if (l != null)
					return l;
			}
		}
		if (right != null) {
			if (right.getVal().equals(val)) {
				return right;
			} else {
				Node<T> r = findNode(right.getLeft(), right.getRight(), val);
				if (r != null)
					return r;
			}
		}
		return null;
	}

	public Node<T> findLowestCommonAncestor(T first, T second) {
		ArrayList<Node<T>> ancestors1 = findAncestors(first);
		ArrayList<Node<T>> ancestors2 = findAncestors(second);

		int l1 = ancestors1.size();
		int l2 = ancestors2.size();
		if (l1 == 0 || l2 == 0) {
			return null;
		}
		int l = Math.min(l1, l2);

		for (int i = 1; i <= l; i++) {
			if (!ancestors1.get(l1 - i).equals(ancestors2.get(l2 - i))) {
				return ancestors1.get(l1 - i + 1);
			}
		}

		return ancestors1.get(l1 - l);

	}

}
