package ru.job4j.parking;

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
        return 0;
    }

    @Override
    public String getLpn() {
        return null;
    }
}
