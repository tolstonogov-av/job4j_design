package ru.job4j.tiktaktoe;

/**
 * Interface for game.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Game {

    /**
     * Starts the game and finish it.
     */
    void start();

    /**
     * Gets result of game.
     *
     * @return result of game, that is finish.
     */
    Result getResult();
}
