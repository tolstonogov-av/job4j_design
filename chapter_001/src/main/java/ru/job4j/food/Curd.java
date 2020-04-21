package ru.job4j.food;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class for curd.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class Curd extends AbstractFood {
    /**
     * Fat of curd.
     */
    private final float fatContent;

    public Curd(String name, Calendar expirationDate, Calendar createDate, double price, float fatContent) {
        super(name, expirationDate, createDate, price);
        this.fatContent = fatContent;
    }

    public float getFatContent() {
        return fatContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Curd curd = (Curd) o;
        return Float.compare(curd.fatContent, fatContent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fatContent);
    }
}
