package ru.job4j.storage;

import ru.job4j.food.AbstractFood;

import java.util.Calendar;

/**
 * Class for trash.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class Trash extends AbstractStorage {
    /**
     * The director of trash house.
     */
    private final String director;

    public Trash(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public boolean isRelevant(AbstractFood food) {
        return food.usedTerm() > 100;
    }
}
