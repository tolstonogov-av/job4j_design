package ru.job4j.tiktaktoe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for test class ComputerInput.
 *
 * @see ComputerInput
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ComputerInputTest {

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
    public void ask() {
        Input computerInput = new ComputerInput();
        Board boardSize3Win3 = new GameBoard(3);
        boardSize3Win3.setSign('X', new FieldCoordinate(0, 0));
        boardSize3Win3.setSign('X', new FieldCoordinate(0, 1));
        boardSize3Win3.setSign('X', new FieldCoordinate(1, 2));
        boardSize3Win3.setSign('O', new FieldCoordinate(1, 0));
        boardSize3Win3.setSign('O', new FieldCoordinate(1, 1));
        boardSize3Win3.setSign('O', new FieldCoordinate(2, 1));
        List<Coordinate> emptyFields = boardSize3Win3.getEmptyFields();
        String[] resultArray1 = computerInput.ask("", boardSize3Win3).split(", ");
        Coordinate result1 = new FieldCoordinate(Integer.parseInt(resultArray1[0]), Integer.parseInt(resultArray1[1]));
        String[] resultArray2 = computerInput.ask("", boardSize3Win3).split(", ");
        Coordinate result2 = new FieldCoordinate(Integer.parseInt(resultArray2[0]), Integer.parseInt(resultArray2[1]));
        String[] resultArray3 = computerInput.ask("", boardSize3Win3).split(", ");
        Coordinate result3 = new FieldCoordinate(Integer.parseInt(resultArray3[0]), Integer.parseInt(resultArray3[1]));
        assertTrue(emptyFields.contains(result1));
        assertTrue(emptyFields.contains(result2));
        assertTrue(emptyFields.contains(result3));
    }
}