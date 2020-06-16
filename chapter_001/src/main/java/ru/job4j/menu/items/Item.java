package ru.job4j.menu.items;

import java.util.List;

/**
 * Interface for items of menu with simple action.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Item {

    /**
     * Returns number in order at the current menu level.
     *
     * @return number in order at the current menu level
     */
    int getNn();

    /**
     * Returns string, which contains name of item and full number.
     *
     * @return string, which contains name of item and full number
     */
    String getFullName();

    /**
     * Returns list of children of item.
     *
     * @return list of children of item
     */
    List<Item> getChildren();

    /**
     * Sets the parent of item.
     *
     * @param parent parent of current item
     */
    void setParent(Item parent);

    /**
     * Gets the parent of current item.
     *
     * @return parent of current item
     */
    Item getParent();

    /**
     * Adds child to children of current item.
     *
     * @param item child to added
     */
    void addChild(Item item);

    /**
     * Returns the result of simple action - name of action.
     *
     * @return result of simple action
     */
    String doAction();
}
