
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

	public void delete(String string) {
		root = delete(string, root);
	}

	public void print() {
		print(root);
	}
	
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
	
	private Comparable removesmallest(Node node) {
		if(node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removesmallest(node.left);
	}
	
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
