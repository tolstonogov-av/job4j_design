package ru.job4j.food;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class for orange.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class Orange extends AbstractFood {
    /**
     * Minimum diameter of fruit , in mm.
     */
    private final int minDiameter;

    public Orange(String name, Calendar expirationDate, Calendar createDate, double price, int minDiameter) {
        super(name, expirationDate, createDate, price);
        this.minDiameter = minDiameter;
    }

    public int getMinDiameter() {
        return minDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Orange orange = (Orange) o;
        return minDiameter == orange.minDiameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minDiameter);
    }
}
