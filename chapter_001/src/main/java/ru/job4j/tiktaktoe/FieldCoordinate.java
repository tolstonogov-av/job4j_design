package ru.job4j.tiktaktoe;

import java.util.Objects;

/**
 * Class for coordinate of field.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class FieldCoordinate implements Coordinate {

    private final int x;

    private final int y;

    public FieldCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldCoordinate that = (FieldCoordinate) o;
        return x == that.x
                && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
