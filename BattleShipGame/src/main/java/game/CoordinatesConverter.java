package game;

public class CoordinatesConverter {

    public static int convertColumnToNumber(char column) {
        if (column < 'A' || column > 'J') {
            throw new IllegalArgumentException("Incorrect column");
        }
        return column - 'A' + 1;
    }

    public static int convertRowToNumber(String rowString) {
        int row = Integer.parseInt(rowString);
        if (row < 1 || row > 10) {
            throw new IllegalArgumentException("Incorrect row");
        }
        return row;
    }
}
