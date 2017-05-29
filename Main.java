public class Main {

	public static void main(String[] args) {
		
		//Build binary tree from the assignment
		BinaryTree<Integer> bt = new BinaryTree<>(16); 
		bt.add(16, 9, true) ;
		bt.add(16, 18, false); 
		bt.add(9, 3, true); 
		bt.add(9, 14, false);
		bt.add(18, 19, false); 
		bt.add(3, 1, true); 
		bt.add(3, 5, false); 

		System.out.println("Valid test for ancestorss: ");
		System.out.println("Expected: 3 9 16, result is: " + bt.printAncestors(5));
		System.out.println();
		
		System.out.println("Print ancestors of the root: ");
		System.out.println(bt.printAncestors(16));
		System.out.println();

		System.out.println("Print ancestors of node that is not in the tree: ");
		System.out.println(bt.printAncestors(-16));
		System.out.println();

		System.out.println("Valid test for lowest common ancestor");
		System.out.println("Expected: 9, result is: " + bt.findLowestCommonAncestor(5, 14));
		System.out.println();

		System.out.println("Test for lowest common ancestor between root and node: ");
		System.out.println("Expected: null, result is: " + bt.findLowestCommonAncestor(5, 16));
		System.out.println();

		System.out.println("Test for lowest common ancestor for the same node:");
		System.out.println("Expected: 18, result is: " + bt.findLowestCommonAncestor(19, 19));
		System.out.println();

		System.out.println("Test for lowest common ancestor between node that is in the tree and node that is not in the tree: ");
		System.out.println("Expected null, result is: " + bt.findLowestCommonAncestor(9, -10));
		System.out.println("Expected null, result is: " + bt.findLowestCommonAncestor(-10, 9));
		System.out.println();
		
		System.out.println("Test for lowest common ancestor between two nodes that are not in the tree: ");
		System.out.println("Expected null, result is: " + bt.findLowestCommonAncestor(100, -10));
		System.out.println();
	}

	
}
