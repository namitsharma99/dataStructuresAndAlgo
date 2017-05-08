package trees;

public class NodeRemover {

	public static void main(String[] args) {

		// Once node class is in place, your are good to create a tree
		Node rootNode = new Node(null);
		rootNode.setId("root");

		Node childNode1 = createChild(rootNode, "child 1");
		Node childNode11 = createChild(childNode1, "Child 11");
		createChild(childNode11, "Child 111");
		createChild(childNode11, "Child 112");
		Node childNode12 = createChild(childNode1, "Child 12");
		createChild(childNode12, "Child 121");
		createChild(childNode12, "Child 122");

		Node childNode2 = createChild(rootNode, "child 2");
		Node childNode21 = createChild(childNode2, "Child 21");
		createChild(childNode21, "Child 211");
		createChild(childNode21, "Child 212");
		Node childNode22 = createChild(childNode2, "Child 22");
		createChild(childNode22, "Child 221");
		createChild(childNode22, "Child 222");

		System.out.println("Depth First Traversal Before Deletion --> ");
		depthFirstTraversal(rootNode, "-");
		
		// childNode2.deleteNode();
		try {
			//childNode1.deleteRootNode();
			rootNode = rootNode.deleteRootNode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Depth First Traversal After Deletion --> ");
		depthFirstTraversal(rootNode, "-");
		
		

	}

	private static Node createChild(Node parent, String id) {
		Node node = new Node(parent);
		node.setId(id);
		parent.getChildren().add(node);
		return node;
	}

	private static void depthFirstTraversal(Node node, String result) {
		System.out.println(result + node.getId());
		for (Node nodeElem : node.getChildren()) {
			depthFirstTraversal(nodeElem, result + result);
		}
	}

}
