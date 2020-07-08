package ru.job4j.tiktaktoe;

import java.util.Objects;

/**
 * Class for result of tik-tak-toe.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class GameResult implements Result {

    /**
     * Winner sign.
     * May be:
     *  0 - for not result,
     *  X - for X win,
     *  O - for O win,
     *  D - for draw.
     */
    private final char sign;

    GameResult(char sign) {
        this.sign = sign;
    }

    @Override
    public char getSign() {
        return this.sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return sign == that.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }
}