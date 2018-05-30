package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Node;

class TestNode {

	@Test
	void testEqual() {
		Node node1 = new Node("A1", "3 4 +");
		Node node2 = new Node("A1", "3 4 + 2 *");
		assertEquals(node1, node2);
		assertEquals(node1.hashCode(), node2.hashCode());
		
	}
	
	@Test
	void testFormula() {
		Node node1 = new Node("A1", "3 4 +");
		assertEquals(node1.getValue(), 7);
		
		Node node2 = new Node("A1", "3 4 + 2 *");
		assertEquals(node2.getValue(), 14);
	}

}
