package ru.job4j.menu.items;

/**
 * Interface for items of menu with action with parameters.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface ItemActionWithParameters extends Item {

    /**
     * Returns the result of calculating with two operands.
     *
     * @return result of calculating
     */
    int doActionWithParameters(int param1, int param2);
}
