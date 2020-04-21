package ru.job4j.storage;

/**
 * Class for warehouse.
 *
 * @author Tosltonogov Alexey
 * @version 1.0
 */
public class Warehouse extends AbstractStorage {
    /**
     * Capacity of warehouse, in m3.
     */
    private final int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
