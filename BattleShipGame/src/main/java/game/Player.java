package game;

public class Player {
    private final String name;
    private final Board playerBoard;
    private final Board attackingBoard;

    public int getSunkShipsCells() {
        int sunkShipsCells = 0;
        Board playerBoard = getPlayerBoard();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                char cellValue = playerBoard.getCell(col, row);
                if (cellValue == 'X') {
                    sunkShipsCells++;
                }
            }
        }
        return sunkShipsCells;
    }

    public int getPlacedShipsCells() {
        int placedShipsCells = 0;
        Board playerBoard = getPlayerBoard();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                char cellValue = playerBoard.getCell(col, row);
                if (cellValue == 'O') {
                    placedShipsCells++;
                }
            }
        }
        return placedShipsCells;
    }


    Player(String name) {
        this.name = name;
        this.playerBoard = new Board();
        this.attackingBoard = new Board();
    }

    String getName() {
        return name;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    Board getAttackingBoard() {
        return attackingBoard;
    }

    void attack(Player player, String coordinates) {
        char cell = player.getPlayerBoard().getCell(coordinates);

        if (cell=='O') {
            attackingBoard.setCell(coordinates,'X');
            System.out.println("You hit a ship");
        } else if (cell=='-') {
            System.out.println("You missed");
            attackingBoard.setCell(coordinates,'*');
        } else {
            System.out.println("You already hit that place");
        }
    }
}
