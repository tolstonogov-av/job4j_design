package ru.job4j.storage;

import ru.job4j.food.AbstractFood;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Class for any storage.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public abstract class AbstractStorage {
    /**
     * Desired storage.
     */
    private final List<AbstractFood> storage = new ArrayList<>();

    /**
     * Adds food's item to the storage.
     *
     * @param food food to add
     */
    public void addItem(AbstractFood food) {
        storage.add(food);
    }

    /**
     * Determines whether specified food is relevant for this storage.
     *
     * @param food checked food
     * @return result of check
     */
    public abstract boolean isRelevant(AbstractFood food);

    /**
     * Returns last element of storage.
     *
     * @return last element of storage.
     */
    public AbstractFood getLastItem() {
        return storage.get(storage.size() - 1);
    }
}
