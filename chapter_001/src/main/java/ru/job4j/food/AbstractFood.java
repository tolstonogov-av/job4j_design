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
     * Date of creation food.
     */
    private final long createDate;

    /**
     * The expiration date of food.
     */
    private final long expirationDate;

    /**
     * Actual price.
     */
    private final double price;

    /**
     * Discount on price.
     */
    private double discount;

    public AbstractFood(String name, long createDate, long expirationDate, double price) {
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
        return createDate == that.createDate
                && expirationDate == that.expirationDate
                && Double.compare(that.price, price) == 0
                && Double.compare(that.discount, discount) == 0
                && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expirationDate, price, discount);
    }

    /**
     * Calculates how much of the expiration date is used.
     *
     * @return how much of the expiration date is used in percent
     */
    public float usedTerm() {
        long used = System.currentTimeMillis() - createDate;
        long live = expirationDate - createDate;
        return (float) used / live * 100;
    }
}
