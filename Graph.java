import java.util.*;

public class Graph {
	private final Map<Node, List<Node>> adj;
	private final List<Node> nodes;
	
	public Graph(String[][] data) {
		adj = new HashMap<Node, List<Node>>();
		nodes = new ArrayList<Node>();
		
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++) {
				String id = Utils.getRowHeader(i + 1) + (j + 1);
				Node node = new Node(id, data[i][j]);
				nodes.add(node);
			}
		for (Node node : nodes) {
			adj.put(node, new ArrayList<Node>());
		}
		processNodes();
	}
	
	private void processNodes() {
		Set<Node> visited = new HashSet<Node>();
		for (Node node : nodes)
			for (Node otherNode : nodes) {
				if (node.getFormula().contains(otherNode.getId())) {
					adj.get(node).add(otherNode);
				}
		}
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
		for (Node node : nodes) {
			System.out.println(String.format("%.5f",node.getValue()));
		}
	}
}
