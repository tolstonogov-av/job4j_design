package ru.job4j.storage;

import ru.job4j.food.AbstractFood;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for any storage.
 *
 * @author Tolstonogov Alexey
 * @version 2.0
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
        AbstractFood result = null;
        if (this.storage.size() > 0) {
            result = storage.get(storage.size() - 1);
        }
        return result;
    }

    /**
     * Extract last added element of starage.
     *
     * @return extracted element
     */
    public AbstractFood extractLastItem() {
        AbstractFood result = this.getLastItem();
        if (result != null) {
            this.storage.remove(storage.size() - 1);
        }
        return result;
    }
}
