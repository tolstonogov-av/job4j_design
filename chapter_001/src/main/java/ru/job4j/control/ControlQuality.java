package ru.job4j.control;

import ru.job4j.food.AbstractFood;
import ru.job4j.storage.AbstractStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for distribution food to different storages.
 *
 * @author Tolstonogov Alexey
 * @version 2.0
 */
public class ControlQuality {
    /**
     * Storages.
     */
    private final List<AbstractStorage> storages = new ArrayList<>();

    /**
     * Adds specified storage to storages.
     *
     * @param storage storage to add
     */
    public void addStorage(AbstractStorage storage) {
        this.storages.add(storage);
    }

    /**
     * Distributes food to different storages.
     *
     * @param food food to distribute
     */
    public void distribution(AbstractFood food) {
        for (AbstractStorage storage : storages) {
            if (storage.isRelevant(food)) {
                storage.addItem(food);
                break;
            }
        }
    }

    /**
     * Redistributes all food from all storage.
     */
    public void revert() {
        this.enter(this.extract());
    }

    /**
     * Extracts all food from all storages.
     *
     * @return all extracted food
     */
    private List<AbstractFood> extract() {
        List<AbstractFood> result = new ArrayList<>();
        AbstractFood food;
        for (AbstractStorage storage : storages) {
            food = storage.extractLastItem();
            while (food != null) {
                result.add(food);
                food = storage.extractLastItem();
            }
        }
        return result;
    }

    /**
     * Distributes specified foods into storages.
     *
     * @param foods foods to distribute
     */
    private void enter(List<AbstractFood> foods) {
        for (AbstractFood food : foods) {
            this.distribution(food);
        }
    }
}
