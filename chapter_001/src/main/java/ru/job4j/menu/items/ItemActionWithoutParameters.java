package ru.job4j.menu.items;

/**
 * Interface for items of menu with action without parameters.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface ItemActionWithoutParameters extends Item {

    /**
     * Returns the result of action without parameters.
     *
     * @return result of action
     */
    String doActionWithoutParameters();
}
