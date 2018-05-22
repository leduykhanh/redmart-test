import java.util.regex.Pattern;

public class Node {
	String id;
	double value;
	String formula;
	public boolean evaluated;
	
	public Node(String id, String formula) {
		this.id = id;
		this.formula = formula;
		processFormula();
	}
	
	public Node(String id, String formula, double value) {
		this.id = id;
		this.formula = formula;
		this.value = value;
		processFormula();
	}
	
	public void processFormula() {	
		try { 
			value = Integer.parseInt(formula);
			evaluated = true;
			 }
		catch (NumberFormatException er){ 
			if (!Pattern.matches("(.*)[A-Z]+(.*)", formula)) {
				value = ReversePolishNotation.calc(formula);
				evaluated = true;
			}
		}
	}
	
	public String getId() {
		return id;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getFormula() {
		return formula;
	}
	
	public void setFormula(String formula) {
		this.formula = formula;
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
