import java.util.*;

public class Graph {
	private final Map<Node, List<Node>> adj;
	private final List<Node> nodes;
	private int rows, cols;
	
	public Graph(String[][] data) {
		adj = new HashMap<Node, List<Node>>();
		nodes = new ArrayList<Node>();
		rows = data.length;
		cols = data[0].length;
		
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				String id = Utils.getRowHeader(i + 1) + (j + 1);
				Node node = new Node(id, data[i][j]);
				nodes.add(node);
			}
		for (Node node : nodes) {
			adj.put(node, new ArrayList<Node>());
		}
		processNodes();
	}
	
	private boolean isCyclicDfs(Node node, Set<Node> visited, Set<Node> recStack) {
		if (recStack.contains(node)) return true;
		if (visited.contains(node)) return false;
		
		visited.add(node);
		recStack.add(node);
		for (Node child : adj.get(node)) {
			if (isCyclicDfs(child, visited, recStack))
				return true;
		}
		recStack.remove(node);
		
		return false;
	}
	
	private boolean isCyclic() {
		Set<Node> visited = new HashSet<Node>();
		Set<Node> recStack = new HashSet<Node>();
		for (Node node : nodes) 
			if (isCyclicDfs(node, visited, recStack))
				return true;
		return false;
	}
	
	private void processNodes() {
		for (Node node : nodes)
			for (Node otherNode : nodes) {
				if (node.getFormula().contains(otherNode.getId())) {
					adj.get(node).add(otherNode);
				}
		}
	}
	
	private void updateNodes() {
		Set<Node> visited = new HashSet<Node>();
		for (Node node : nodes) dfs(node, visited);
	}
	
	public void dfs(Node node, Set<Node> visited) {
		if (visited.contains(node)) return;
		visited.add(node);
		for (Node child : adj.get(node)) {
			if (child.evaluated) {
				node.setFormula(node.getFormula().replace(child.getId(), child.getValue() + ""));
			}
			dfs(child, visited);
		}
		node.processFormula();
	}
	
	void printGraph() {
		for (Node node : adj.keySet()) {
			System.out.print(node);
			for (Node child : adj.get(node)) {
				System.out.print("-" + child.toString());
			}
			System.out.println();
		}
	}
	
	void printSheet() {
		if(isCyclic()) {
			System.out.println("The input spreadsheet is cyclic");
			System.exit(0);
		}
		updateNodes();
		System.out.print(cols + " " + rows);
		System.out.println();
		for (Node node : nodes) {
			System.out.println(String.format("%.5f",node.getValue())	);
		}
	}
}
