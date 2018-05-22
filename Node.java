
public class Node {
	String id;
	double value;
	String formula;
	
	public Node(String id, String formula, double value) {
		this.id = id;
		this.formula = formula;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return node.getId().equals(id);
    }
	
	@Override
    public int hashCode() {
		return id.hashCode();
	}
	
}
