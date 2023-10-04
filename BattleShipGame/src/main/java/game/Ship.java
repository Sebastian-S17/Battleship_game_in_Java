package game;

public class Ship {
    private static int shipLength;
    static boolean CollisionHappened;

    public Ship(int shipLength) {
        Ship.shipLength = shipLength;
    }

    public static void place(Player player, String coordinates, int shipLength, boolean vertical) {
        CollisionHappened = false;
        int rowIndex = CoordinatesConverter.convertRowToNumber(coordinates.substring(1));
        int columnIndex = CoordinatesConverter.convertColumnToNumber(coordinates.toUpperCase().charAt(0));

        if (!isCollisionFree(player, rowIndex, columnIndex, shipLength, vertical)) {
            System.out.println("\n"+"The collision has occurred!");
            return;
        }
        for (int shipBody = 0; shipBody < shipLength; shipBody++) {
            player.getPlayerBoard().setCell(rowIndex,columnIndex, 'O');
            if (vertical) rowIndex--;
            else columnIndex++;
        }
    }

    private static boolean legalMove(Player player, String coordinates, boolean vertical) {
        int rowIndex = CoordinatesConverter.convertRowToNumber(coordinates.substring(1));
        int columnIndex = CoordinatesConverter.convertColumnToNumber(coordinates.toUpperCase().charAt(0));
        if (vertical) {
            if (rowIndex + shipLength - 1 > 10) return false;
            for (int i = 0; i < shipLength; i++) {
                char cell = player.getPlayerBoard().getCell(rowIndex + i, columnIndex);
                if (cell != '-' && cell != 'O') return false;
            }
        } else {
            if (columnIndex + shipLength - 1 > 10) return false;
            for (int i = 0; i < shipLength; i++) {
                char cell = player.getPlayerBoard().getCell(rowIndex, columnIndex + i);
                if (cell != '-' && cell != 'O') return false;
            }
        }
        return true;
    }


    private static boolean isCollisionFree(Player player, int x, int y, int shipLength, boolean vertical) {
        for (int shipBody = 0; shipBody < shipLength; shipBody++) {
            if (player.getPlayerBoard().getCell(x, y)=='O') {
                CollisionHappened = true;
                return false;
            }
            if (vertical) x--;
            else y++;
        }
        return true;
    }

}