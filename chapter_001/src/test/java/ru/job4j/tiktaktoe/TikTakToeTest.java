package ru.job4j.tiktaktoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for test class TikTakToe.
 *
 * @see TikTakToe
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class TikTakToeTest {

    /**
     *    0 1 2
     *    _____
     * 0 |X O O
     * 1 |X O
     * 2 |X X
     *
     * X - win
     */
    @Test
    public void testSize3LengthWin3() {
        StubInput stubInputSize3LengthWin3 = new StubInput(new String[]{
                "3",
                "3",
                "h h",
                "0, 0",
                "1, 0",
                "0, 1",
                "1, 1",
                "1, 2",
                "2, 1",
                "0, 2"
        });
        Game tikTakToeSize3LengthWin3 = new TikTakToe(stubInputSize3LengthWin3);
        tikTakToeSize3LengthWin3.start();
        Player player = new GamePlayer(stubInputSize3LengthWin3, 'X');
        Result expected = new GameResult(player.getSign());
        assertEquals(expected, tikTakToeSize3LengthWin3.getResult());
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
    public void testSize5LengthWin3() {
        StubInput stubInputSize5LengthWin3 = new StubInput(new String[]{
                "5",
                "3",
                "h h",
                "1, 3",
                "0, 1",
                "2, 0",
                "1, 1",
                "2, 3",
                "2, 1"
        });
        Game tikTakToeSize5LengthWin3 = new TikTakToe(stubInputSize5LengthWin3);
        tikTakToeSize5LengthWin3.start();
        Player player = new GamePlayer(stubInputSize5LengthWin3, 'O');
        Result expected = new GameResult(player.getSign());
        assertEquals(expected, tikTakToeSize5LengthWin3.getResult());
    }

    /**
     *    0 1 2 3 4
     *    _________
     * 0 |    X
     * 1 |O O O O O
     * 2 |      X
     * 3 |  X X   X
     * 4 |
     *
     * O - win
     */
    @Test
    public void testSize5LengthWin5() {
        StubInput stubInputSize5LengthWin5 = new StubInput(new String[]{
                "5",
                "5",
                "h h",
                "1, 3",
                "0, 1",
                "2, 0",
                "1, 1",
                "2, 3",
                "2, 1",
                "3, 2",
                "3, 1",
                "4, 3",
                "4, 1"
        });
        Game tikTakToeSize5LengthWin5 = new TikTakToe(stubInputSize5LengthWin5);
        tikTakToeSize5LengthWin5.start();
        Player player = new GamePlayer(stubInputSize5LengthWin5, 'O');
        Result expected = new GameResult(player.getSign());
        assertEquals(expected, tikTakToeSize5LengthWin5.getResult());
    }
}