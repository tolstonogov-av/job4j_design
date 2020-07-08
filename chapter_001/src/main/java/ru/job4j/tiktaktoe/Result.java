package ru.job4j.tiktaktoe;

/**
 * Interface for result of game.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Result {

    /**
     * Gets the result of game.
     *
     * @return result: D - if draw, X - if X win, O - if O win
     */
    char getSign();
}
