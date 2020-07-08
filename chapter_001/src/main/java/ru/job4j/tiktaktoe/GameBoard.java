package ru.job4j.tiktaktoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for board of tik-tak-toe.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class GameBoard implements Board {

    /**
     * Size of board.
     */
    private final int size;

    /**
     * Array that represented the fields of board.
     */
    private final char[][] fields;

    public GameBoard(int size) {
        this.size = size;
        this.fields = new char[size][size];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String printBoard() {
        StringBuilder result = new StringBuilder(System.lineSeparator());
        result.append("   ");
        for (int i = 0; i < this.size; i++) {
            result.append(i);
            if (i != this.fields.length - 1) {
                result.append(' ');
            }
        }
        result.append(System.lineSeparator());
        result.append("   ");
        result.append("_".repeat(this.size * 2 - 1));
        result.append(System.lineSeparator());
        for (int y = 0; y < this.fields.length; y++) {
            result.append(y).append(" |");
            for (int x = 0; x < this.fields.length; x++) {
                result.append(this.fields[x][y] == 0 ? ' ' : this.fields[x][y]);
                if (x != this.fields.length - 1) {
                    result.append(' ');
                }
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public void setSign(char sign, Coordinate coordinate) {
        this.fields[coordinate.getX()][coordinate.getY()] = sign;
    }

    @Override
    public char getSign(Coordinate coordinate) {
        return this.fields[coordinate.getX()][coordinate.getY()];
    }

    @Override
    public List<Coordinate> getEmptyFields() {
        List<Coordinate> result = new ArrayList<>();
        for (int x = 0; x < this.fields.length; x++) {
            for (int y = 0; y < this.fields.length; y++) {
                if (this.fields[x][y] == 0) {
                    result.add(new FieldCoordinate(x, y));
                }
            }
        }
        return result;
    }
}
