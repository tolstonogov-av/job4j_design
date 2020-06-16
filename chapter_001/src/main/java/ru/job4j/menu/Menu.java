package ru.job4j.menu;

import ru.job4j.menu.items.Item;

/**
 * Interface for menu of user actions.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Menu {

    /**
     * Adds child item to parent item.
     *
     * @param parent parent item
     * @param child item to add
     */
    void addChild(Item parent, Item child);

    /**
     * Adds child item to root (0) level.
     *
     * @param child item to add
     */
    void addChild(Item child);

    /**
     * Outputs all item's full-names to string.
     *
     * @return list of items
     */
    String showMenu();
}
