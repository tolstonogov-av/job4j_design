package ru.job4j.parking;

import java.util.Objects;

/**
 * Universal class for lorry and passenger car.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class SimpleCar implements Car {
    /**
     * Size of car.
     */
    private final int size;

    /**
     * Licence plate number of car.
     */
    private final String lpn;

    public SimpleCar(int size, String lpn) {
        this.size = size;
        this.lpn = lpn;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getLpn() {
        return this.lpn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleCar simpleCar = (SimpleCar) o;
        return lpn.equals(simpleCar.lpn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lpn);
    }
}
