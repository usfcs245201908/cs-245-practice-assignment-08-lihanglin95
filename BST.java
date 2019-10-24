
public class BST<T> {
	Node root;
	
	public BST() {
		root = null;
	}
	
	class Node<T>{
		Comparable data;
		Node left;
		Node right;
		int instance = 0;
		
		public Node(Comparable testString) {
			data = testString;
		}
	}

	public void insert(Comparable testString) {
		root = insert(testString, root);	
	}

	public boolean find(Comparable testString) {
		return find(testString, root);
	}

	public void delete(Comparable testString) {
		root = delete(testString, root);
	}

	public void print() {
		print(root);
	}
	
	/**
	 * This method is to check if there is the target testString in the tree
	 * @param testString This is the String passed by class Practice08test
	 * @param node This is the current node that is checking
	 * @return This returns true if the String is found
	 */
	private boolean find(Comparable testString, Node node) {
		if(node == null)
			return false;
		
		if(testString.compareTo(node.data) == 0)
			return true;
		
		if(testString.compareTo(node.data) < 0)
			return find(testString, node.left);
		else
			return find(testString, node.right);	
	}
	
	/**
	 * This method is to insert a String to the tree
	 * @param testString This is the String passed by class Practice08test
	 * @param node This is the current node that is checking
	 * @return This returns a node that is the root
	 */
	private Node insert(Comparable testString, Node node) {
		if(node == null)
			return new Node(testString);
		
		if(testString.compareTo(node.data) == 0) {
			node.instance++;
			return node;
		}
		
		if(testString.compareTo(node.data) < 0)
			node.left = insert(testString, node.left);
		else
			node.right = insert(testString, node.right);
		return node;
			
	}
	
	/**
	 * This method is to delete the String from the tree
	 * @param testString This is the String passed by class Practice08test
	 * @param node This is the current node that is checking
	 * @return This returns a node that is the root
	 */
	private Node delete(Comparable testString, Node node) {
		if(node == null)
			return null;
		
		if(testString.compareTo(node.data) == 0) {
			if(node.instance > 0)
				node.instance--;
			else {
				if(node.left == null)
				return node.right;
			
				if(node.right == null)
					return node.left;
			
				if(node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else {
					node.data = removesmallest(node.right);
					return node;
				}
			}
				
		}
		
		if(testString.compareTo(node.data) < 0) {
			node.left = delete(testString, node.left);
			return node;
		}
		else {
			node.right = delete(testString, node.right);
			return node;
		}
	}
	
	/**
	 * This method is to remove the smallest String
	 * @param node This is the current node that is checking
	 * @return This returns the smallest String
	 */
	private Comparable removesmallest(Node node) {
		if(node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removesmallest(node.left);
	}
	
	/**
	 * This method is to print the tree in order
	 * @param node This is the current node that is checking
	 * @return This returns the current node that is printed
	 */
	private Node print(Node node) {
		if(node == null)
			return null;
		
		print(node.left);
		for (int i = node.instance; i >= 0; i--){
			System.out.println(node.data);
		}
        
		print(node.right);
		return node;
	}

}
