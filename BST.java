
public class BST<T> {
	Node root;
	
	/*
	 * This is the constructor of class BST
	 */
	public BST() {
		root = null;
	}
	
	/*
	 * This inner class defines Node
	 */
	class Node<T>{
		Comparable data;
		Node left;
		Node right;
		int instance = 0;
		
		/*
		 * This is the constructor of inner class Node
		 */
		public Node(Comparable testString) {
			data = testString;
		}
	}

	/*
	 * This insert method calls the other recursive insert method
	 */
	public void insert(Comparable testString) {
		root = insert(testString, root);	
	}

	/*
	 * This find method calls the other recursive find method
	 */
	public boolean find(Comparable testString) {
		return find(testString, root);
	}

	/*
	 * This delete method calls the other recursive delete method
	 */
	public void delete(Comparable testString) {
		root = delete(testString, root);
	}

	/*
	 * This print method calls the other recursive print method
	 */
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
