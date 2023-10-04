package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    public Player player;
    @BeforeEach
    public void setUp() {
        player = new Player("name");
    }


    @Test
    public void placeShipAtTheEdgeOfTheBoard() {
        Ship ship = new Ship(2);
        Ship.place(player, "J10", 5, true);
        assertEquals('O', player.getPlayerBoard().getCell(10,10));
        assertEquals('O', player.getPlayerBoard().getCell(9, 10));
    }

    @Test
    public void testPlaceShipVertical() {
        Ship ship = new Ship(3);
        Ship.place(player, "A3", 3, true);
        assertEquals('O', player.getPlayerBoard().getCell(1,1));
        assertEquals('O', player.getPlayerBoard().getCell(2, 1));
        assertEquals('O', player.getPlayerBoard().getCell(3, 1));
    }

    @Test
    public void testPlaceShipHorizontal() {
        Ship ship = new Ship(4);
        Ship.place(player, "B2", 4, false);
        assertEquals('O', player.getPlayerBoard().getCell(2, 2));
        assertEquals('O', player.getPlayerBoard().getCell(2, 3));
        assertEquals('O', player.getPlayerBoard().getCell(2, 4));
        assertEquals('O', player.getPlayerBoard().getCell(2, 5));
    }

    @Test
    public void testPlaceShipAtWrongRow() {
        assertThrows(IllegalArgumentException.class,
                () -> Ship.place(player,"D11",4, false));
    }

    @Test
    public void testPlaceShipAtWrongCollumn() {
        assertThrows(IllegalArgumentException.class,
                () -> Ship.place(player,"S3",4, false));
    }
}