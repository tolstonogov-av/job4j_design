package ru.job4j.tiktaktoe;

import java.util.Objects;

/**
 * Class for player of tik-tak-toe.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class GamePlayer implements Player {

    /**
     * Input for player.
     */
    private final Input input;

    /**
     * Signed sign of player.
     */
    private char sign;

    public GamePlayer(Input input, char sign) {
        this.input = input;
        this.sign = sign;
    }

    @Override
    public void setSign(char sign) {
        this.sign = sign;
    }

    @Override
    public char getSign() {
        return this.sign;
    }

    @Override
    public Coordinate move(Board board) {
        String[] coordinate = this.input.ask("your move: ", board).split(", ");
        return new FieldCoordinate(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GamePlayer that = (GamePlayer) o;
        return sign == that.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }
}
