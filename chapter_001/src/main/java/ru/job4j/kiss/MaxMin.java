package ru.job4j.kiss;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Class for calculate max and min value in the list.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class MaxMin {
    /**
     * KISS.
     *
     * @param value the list of values
     * @param comparator comparator to compare values of the list
     * @param <T> type of values in the list
     * @return max value in the list
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calculate(value, comparator);
    }

    /**
     * KISS.
     *
     * @param value the list of values
     * @param comparator comparator to compare values of the list
     * @param <T> type of values in the list
     * @return min value in the list
     */
   public <T> T min(List<T> value, Comparator<T> comparator) {
        return calculate(value, (o1, o2) -> comparator.compare(o2, o1));
    }

    /**
     * DRY and YAGNI.
     *
     * @param value the list of values
     * @param comparator comparator to compare values of the list
     * @param <T> type of values in the list
     * @return the found value, which depends on the comparator
     */
    private <T> T calculate(List<T> value, Comparator<T> comparator) {
        Iterator<T> iter = value.iterator();
        T result = iter.next();
        while (iter.hasNext()) {
            T element = iter.next();
            if (comparator.compare(element, result) > 0) {
                result = element;
            }
        }
        return result;
    }
}
