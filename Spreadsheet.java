import java.util.Scanner;

public class Spreadsheet {
	public static void main(String[] args) {
		Spreadsheet test = new Spreadsheet();
		Graph graph = new Graph(test.readData());
		graph.printSheet();
	}

	public static Scanner sc = new Scanner(System.in);
	
	String[][] readData() {
		int cols = sc.nextInt();
		int rows = sc.nextInt();
		sc.nextLine();
		String[][] result = new String[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				String line = sc.nextLine();
				result[i][j] = line;
			}
		return result;
		}
}
