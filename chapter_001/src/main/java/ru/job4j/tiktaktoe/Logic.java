package ru.job4j.tiktaktoe;

/**
 * Interface for logic of game.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Logic {

    /**
     * Analyzes the fields of board.
     *
     * @param board board to analyze
     * @param lengthWin length sequence to win
     * @return result of analyze
     */
    Result analyzeBoard(Board board, int lengthWin);

    /**
     * Checks whether the field is empty.
     *
     * @param board board to analyze
     * @param coordinate coordinate of field to analyze
     * @return result of check - true if field is empty, otherwise false
     */
    boolean analyzePossibleMove(Board board, Coordinate coordinate);
}
