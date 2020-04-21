package ru.job4j.storage;

/**
 * Class for shop.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class Shop extends AbstractStorage {
    /**
     * Address of shop.
     */
    private final String address;

    public Shop(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
