package ru.job4j.tiktaktoe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for test class GameBoard.
 *
 * @see GameBoard
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class GameBoardTest {

    private final Board board = new GameBoard(3);

    @Before
    public void before() {
        this.board.setSign('X', new FieldCoordinate(0, 0));
        this.board.setSign('X', new FieldCoordinate(0, 1));
        this.board.setSign('X', new FieldCoordinate(1, 2));
        this.board.setSign('O', new FieldCoordinate(1, 0));
        this.board.setSign('O', new FieldCoordinate(1, 1));
        this.board.setSign('O', new FieldCoordinate(2, 1));
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |  X
     *
     * 0, 1 - X
     */
    @Test
    public void getSign() {
        char expected = 'X';
        assertEquals(expected, this.board.getSign(new FieldCoordinate(0, 1)));
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |  X
     *
     * Empty fields: (0, 2), (2, 0), (2, 2)
     */
    @Test
    public void getEmptyFields() {
        List<Coordinate> expected = List.of(
                new FieldCoordinate(0, 2),
                new FieldCoordinate(2, 0),
                new FieldCoordinate(2, 2)
        );
        assertEquals(expected, this.board.getEmptyFields());
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |  X
     */
    @Test
    public void printBoard() {
        String expected = System.lineSeparator()
                + "   0 1 2"  + System.lineSeparator()
                + "   _____" + System.lineSeparator()
                + "0 |X O  " + System.lineSeparator()
                + "1 |X O O" + System.lineSeparator()
                + "2 |  X  " + System.lineSeparator();
        assertEquals(expected, this.board.printBoard());
    }
}