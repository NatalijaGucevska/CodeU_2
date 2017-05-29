import java.util.ArrayList;

public class BinaryTree<T> {
	Node root;

	public BinaryTree(T root) {
		this.root = new Node(root);
	}

	public boolean add(T current, T newNode, boolean addToLeft) {
		Node currentNode;
		if (current == root.getVal()) {
			currentNode = root;
		} else {
			currentNode = findNode(root.left, root.right, current);
		}
		if (current != null) {
			Node nodeToAdd = new Node(newNode);
			nodeToAdd.setParent(currentNode);

			if (addToLeft) {
				if (currentNode.getLeft() != null) {
					return false;
				}
				currentNode.setLeft(nodeToAdd);
			} else {
				if (currentNode.getRight() != null) {
					return false;
				}
				currentNode.setRight(nodeToAdd);
			}
			return true;
		}
		return false;
	}

	/**
	 * Provides a string containing the ancestors of a specific node. If the
	 * required node is not in the tree or it is the root node, the returned
	 * string contains message explaining that the node doesn't have ancestors
	 * in the tree.
	 * 
	 * @param val
	 *            - The node for which the ancestors are required
	 * @return - A string containing the ancestors of the node
	 */
	public String printAncestors(T val) {
		ArrayList<Node> ancestors = findAncestors(val);
		StringBuilder str = new StringBuilder();

		if (ancestors.size() == 0) {
			return "This node doesn't have ancestors in the tree";
		}
		for (Node a : ancestors) {
			str.append(a.getVal().toString());
			str.append(" ");
		}

		return str.toString();
	}

	/**
	 * Provides a list that contains the ancestors of a specific node If the
	 * node doesn't have ancestors in the tree, the returned list is empty.
	 */
	private ArrayList<Node> findAncestors(T val) {
		Node node = findNode(root.getLeft(), root.getRight(), val);
		ArrayList<Node> ancestors = new ArrayList<>();

		while (node != null && node.getParent() != null) {
			node = node.getParent();
			ancestors.add(node);
		}
		return ancestors;
	}

	/**
	 * Given the value of a node, it finds the specific node in the tree. If
	 * there is no node for the requested value, the returned value is null
	 */
	private Node findNode(Node left, Node right, T val) {
		if (left != null) {
			if (left.getVal().equals(val)) {
				return left;
			} else {
				Node l = findNode(left.getLeft(), left.getRight(), val);
				if (l != null)
					return l;
			}
		}
		if (right != null) {
			if (right.getVal().equals(val)) {
				return right;
			} else {
				Node r = findNode(right.getLeft(), right.getRight(), val);
				if (r != null)
					return r;
			}
		}
		return null;
	}

	/**
	 * For two values of the tree, it finds the lowest common ancestor. If one
	 * of the values doesn't have ancestors in the tree (i.e. it is a root or
	 * value that doesn't belong to the tree) the returned value is null.
	 */
	public T findLowestCommonAncestor(T first, T second) {
		ArrayList<Node> ancestors1 = findAncestors(first);
		ArrayList<Node> ancestors2 = findAncestors(second);

		int l1 = ancestors1.size();
		int l2 = ancestors2.size();
		int l = Math.min(l1, l2);

		if (l1 == 0 || l2 == 0) {
			return null;
		}

		for (int i = 1; i <= l; i++) {
			if (!ancestors1.get(l1 - i).equals(ancestors2.get(l2 - i))) {
				return ancestors1.get(l1 - i + 1).getVal();
			}
		}
		return ancestors1.get(l1 - l).getVal();
	}

	private class Node {
		Node left;
		Node right;
		Node parent;
		T val;

		Node(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		void setParent(Node parent) {
			this.parent = parent;
		}

		void setLeft(Node left) {
			this.left = left;
		}

		void setRight(Node right) {
			this.right = right;
		}

		Node getParent() {
			return this.parent;
		}

		Node getLeft() {
			return this.left;
		}

		Node getRight() {
			return this.right;
		}

		T getVal() {
			return this.val;
		}

	}

}
