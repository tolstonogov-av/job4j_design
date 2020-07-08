package ru.job4j.tiktaktoe;

/**
 * Interface for players.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Player {

    void setSign(char sign);

    char getSign();

    /**
     * Does move of player in game.
     *
     * @param board board of game
     * @return coordinate of field to move
     */
    Coordinate move(Board board);
}
