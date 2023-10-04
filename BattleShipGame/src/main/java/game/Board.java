package game;

public class Board {

    private final char[][] gameBoard;
    private final int boardSize=10;

    public Board() {
        gameBoard = new char[boardSize][boardSize];
        createNewBoard();
    }

    private void createNewBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    void drawBoard() {
        System.out.print(" ");
        for (int index = 0; index < boardSize; index++) {
            char ascii= (char) (index+65);
            System.out.print("  "+ascii);
        }
        System.out.println();
        for (int columns = 0; columns < boardSize; columns++) {
            if (columns+1!=boardSize) System.out.print((columns + 1) + "  ");
            else System.out.print((columns + 1) + " ");
            for (int rows = 0; rows < boardSize; rows++) {
                System.out.print(gameBoard[columns][rows] + "  ");
            }
            System.out.println();
        }
    }

    public void setCell(String coordinates, char value) {
        int rowIndex = CoordinatesConverter.convertRowToNumber(coordinates.substring(1));
        int columnIndex = CoordinatesConverter.convertColumnToNumber(coordinates.toUpperCase().charAt(0));

        gameBoard[rowIndex-1][columnIndex-1]=Character.toUpperCase(value);

    }

    public void setCell(int x, int y, char value) {
        gameBoard[x-1][y-1]=Character.toUpperCase(value);
    }


    public char getCell(String coordinates) {
        int rowIndex = CoordinatesConverter.convertRowToNumber(coordinates.substring(1));
        int columnIndex = CoordinatesConverter.convertColumnToNumber(coordinates.toUpperCase().charAt(0));
        return  gameBoard[rowIndex-1][columnIndex-1];
    }

    public char getCell(int x, int y) {
        return  gameBoard[x-1][y-1];
    }
}
