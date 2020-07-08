package ru.job4j.tiktaktoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test class AnalyzeGame.
 *
 * @see AnalyzeGame
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class AnalyzeGameTest {

    private final Logic analyzeGame = new AnalyzeGame();

    /**
     * Board with size 3.
     */
    private final Board boardSize3 = new GameBoard(3);

    @Before
    public void setBefore() {
        this.boardSize3.setSign('X', new FieldCoordinate(0, 0));
        this.boardSize3.setSign('X', new FieldCoordinate(0, 1));
        this.boardSize3.setSign('X', new FieldCoordinate(0, 2));
        this.boardSize3.setSign('X', new FieldCoordinate(1, 2));
        this.boardSize3.setSign('O', new FieldCoordinate(1, 0));
        this.boardSize3.setSign('O', new FieldCoordinate(1, 1));
        this.boardSize3.setSign('O', new FieldCoordinate(2, 1));
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |X X
     *
     * 2, 0 - is empty
     */
    @Test
    public void analyzePossibleMoveTrue() {
        assertTrue(this.analyzeGame.analyzePossibleMove(this.boardSize3, new FieldCoordinate(2, 0)));
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |X X
     *
     * 2, 1 - is not empty
     */
    @Test
    public void analyzePossibleMoveFalse() {
        assertFalse(this.analyzeGame.analyzePossibleMove(this.boardSize3, new FieldCoordinate(2, 1)));
    }

    /**
     *    0 1 2
     *    _____
     * 0 |X O
     * 1 |X O O
     * 2 |X X
     *
     * X - win
     */
    @Test
    public void analyzeBoardSize3LengthWin3() {
        Player computer = new GamePlayer(new ComputerInput(), 'X');
        Result expected = new GameResult(computer.getSign());
        assertEquals(expected, this.analyzeGame.analyzeBoard(this.boardSize3, 3));
    }

    /**
     *    0 1 2 3 4
     *    _________
     * 0 |    X
     * 1 |O O O
     * 2 |
     * 3 |  X X
     * 4 |
     *
     * O - win
     */
    @Test
    public void analyzeBoardSize5LengthWin3() {
        Board boardSize5 = new GameBoard(5);
        boardSize5.setSign('x', new FieldCoordinate(1, 3));
        boardSize5.setSign('x', new FieldCoordinate(2, 0));
        boardSize5.setSign('x', new FieldCoordinate(2, 3));
        boardSize5.setSign('O', new FieldCoordinate(0, 1));
        boardSize5.setSign('O', new FieldCoordinate(1, 1));
        boardSize5.setSign('O', new FieldCoordinate(2, 1));
        Player human = new GamePlayer(new PlayerInput(), 'O');
        Result expected = new GameResult(human.getSign());
        assertEquals(expected, this.analyzeGame.analyzeBoard(boardSize5, 3));
    }

    /**
     *    0 1 2 3 4
     *    _________
     * 0 |    X
     * 1 |O O O O O
     * 2 |      X
     * 3 |  X X
     * 4 |        X
     *
     * O - win
     */
    @Test
    public void analyzeBoardSize5LengthWin5() {
        Board boardSize5 = new GameBoard(5);
        boardSize5.setSign('x', new FieldCoordinate(1, 3));
        boardSize5.setSign('x', new FieldCoordinate(2, 0));
        boardSize5.setSign('x', new FieldCoordinate(2, 3));
        boardSize5.setSign('x', new FieldCoordinate(3, 2));
        boardSize5.setSign('x', new FieldCoordinate(4, 4));
        boardSize5.setSign('O', new FieldCoordinate(0, 1));
        boardSize5.setSign('O', new FieldCoordinate(1, 1));
        boardSize5.setSign('O', new FieldCoordinate(2, 1));
        boardSize5.setSign('O', new FieldCoordinate(3, 1));
        boardSize5.setSign('O', new FieldCoordinate(4, 1));
        Player human = new GamePlayer(new PlayerInput(), 'O');
        Result expected = new GameResult(human.getSign());
        assertEquals(expected, this.analyzeGame.analyzeBoard(boardSize5, 5));
    }
}