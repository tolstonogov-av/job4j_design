package ru.job4j.tiktaktoe;

import java.util.List;

/**
 * Interface for game board.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Board {

    int getSize();

    /**
     * Creates picture with board.
     *
     * @return string with picture of board
     */
    String printBoard();

    /**
     * Sets sign to specified coordinate.
     *
     * @param sign sign to set
     * @param coordinate coordinate to set sign
     */
    void setSign(char sign, Coordinate coordinate);

    /**
     * Gets sign from specified coordinate.
     *
     * @param coordinate coordinate to get sign
     * @return sign from field by specified coordinate
     */
    char getSign(Coordinate coordinate);

    /**
     * Calculates all empty (without sign) field in board.
     *
     * @return all empty fields (coordinates of them)
     */
    List<Coordinate> getEmptyFields();
}
