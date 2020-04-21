package ru.job4j.food;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class for milk.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class Milk extends AbstractFood {
    /**
     * Volume of milk's bottle.
     */
    private final float volume;

    public Milk(String name, Calendar expirationDate, Calendar createDate, double price, float volume) {
        super(name, expirationDate, createDate, price);
        this.volume = volume;
    }

    public float getVolume() {
        return volume;
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
        Milk milk = (Milk) o;
        return Float.compare(milk.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
