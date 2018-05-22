
public class Utils {
    public static String getRowHeader(int rowIndex) {
        String h = "";
        while (rowIndex > 0) {
            h = (char) ('A' + (rowIndex - 1) % 26) + h;
            rowIndex = (rowIndex - 1) / 26;
        }
        return h;
    }
}
