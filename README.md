# redmart-test

Spreadsheet with formula.

I use a directed graph to store the spreadsheet. Each node is a cell.
If a cell depends on other cells, there are edges from it to corresponding nodes

To solve all cells, I use depth first search algorithm.
- Evaluate cell's value if possible.
- If cell has value, replace the parent node's formula with the value.

The program will exit if there are circles in the graph, since we can't evaluate if it happens.

