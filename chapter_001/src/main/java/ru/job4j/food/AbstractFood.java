package ru.job4j.food;

import java.util.Calendar;
import java.util.Objects;

/**
 * Abstract class for any food.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public abstract class AbstractFood {
    /**
     * Food's name.
     */
    private final String name;

    /**
     * The expiration date of food.
     */
    private final Calendar expirationDate;

    /**
     * Date of creation food.
     */
    private final Calendar createDate;

    /**
     * Actual price.
     */
    private final double price;

    /**
     * Discount on price.
     */
    private double discount;

    public AbstractFood(String name, Calendar expirationDate, Calendar createDate, double price) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractFood that = (AbstractFood) o;
        return Double.compare(that.price, price) == 0
                && Double.compare(that.discount, discount) == 0
                && name.equals(that.name)
                && expirationDate.equals(that.expirationDate)
                && createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expirationDate, createDate, price, discount);
    }

    public float usedTerm(Calendar today) {
        long used = today.getTimeInMillis() - createDate.getTimeInMillis();
        long live = expirationDate.getTimeInMillis() - createDate.getTimeInMillis();
        return (float) used / live * 100;
    }
}
