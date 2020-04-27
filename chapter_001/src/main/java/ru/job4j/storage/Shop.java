package ru.job4j.storage;

import ru.job4j.food.AbstractFood;

import java.util.Calendar;

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

    @Override
    public void addItem(AbstractFood food) {
        if (food.usedTerm() > 75) {
            food.setDiscount(10);
        }
        super.addItem(food);
    }

    @Override
    public boolean isRelevant(AbstractFood food) {
        return food.usedTerm() > 25 && food.usedTerm() <= 100;
    }
}
