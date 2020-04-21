package ru.job4j.control;

import ru.job4j.food.AbstractFood;
import ru.job4j.storage.AbstractStorage;

import java.util.Calendar;

/**
 * Class for distribution food to different storages.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ControlQuality {
    /**
     * Trash storage.
     */
    private final AbstractStorage trash;

    /**
     * Storage - shop.
     */
    private final AbstractStorage shop;

    /**
     * Food warehouse.
     */
    private final AbstractStorage warehouse;

    public ControlQuality(AbstractStorage trash, AbstractStorage shop, AbstractStorage warehouse) {
        this.trash = trash;
        this.shop = shop;
        this.warehouse = warehouse;
    }

    /**
     * Distributes food to different storages using the SOLID principles.
     *
     * @param food food to distribute
     */
    public void distributionLiskov(AbstractFood food, Calendar today) {
        if (food.usedTerm(today) > 100) {
            addItemToStorage(trash, food);
        } else if (food.usedTerm(today) > 75) {
            food.setDiscount(10);
            addItemToStorage(shop, food);
        } else if (food.usedTerm(today) > 25) {
            addItemToStorage(shop, food);
        } else {
            addItemToStorage(warehouse, food);
        }
    }

    /**
     * Adds specified food to specified storage.
     *
     * @param storage storage for food
     * @param food food to add
     */
    private void addItemToStorage(AbstractStorage storage, AbstractFood food) {
        storage.addItem(food);
    }

    /**
     * Distributes food to different storages without using the SOLID principles.
     *
     * @param food food to distribute
     */
    public void distributionNoLiskov(AbstractFood food, Calendar today) {
        if (food.usedTerm(today) > 100) {
            trash.addItem(food);
        } else if (food.usedTerm(today) > 75) {
            food.setDiscount(10);
            shop.addItem(food);
        } else if (food.usedTerm(today) > 25) {
            shop.addItem(food);
        } else {
            warehouse.addItem(food);
        }
    }
}
