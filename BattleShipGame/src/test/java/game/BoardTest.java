package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testSetAndGetCellByCoordinates() {
        board.setCell("A1", 'X');
        assertEquals('X', board.getCell("A1"));
    }

    @Test
    public void testSetAndGetCellByIndices() {
        board.setCell(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1));
    }

    @Test
    public void testSetAndGetCellInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    board.setCell("Z11", 'X');
                });
    }
}