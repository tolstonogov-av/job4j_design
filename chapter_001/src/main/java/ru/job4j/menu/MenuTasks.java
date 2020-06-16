package ru.job4j.menu;

import ru.job4j.menu.items.Item;
import ru.job4j.menu.items.ItemMenuSimple;

/**
 * Class for menu of tasks.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class MenuTasks implements Menu {

    /**
     * Core item of menu.
     */
    private final Item coreItem = new ItemMenuSimple(null, 0, null);

    @Override
    public void addChild(Item parent, Item child) {
        parent.addChild(child);
    }

    @Override
    public void addChild(Item child) {
        coreItem.addChild(child);
    }

    @Override
    public String showMenu() {
        return this.printMenu(this.coreItem, 0).replaceFirst(System.lineSeparator(), "");
    }

    /**
     * Recursively building a list of menu items.
     *
     * @param item item to add to list
     * @param tabs number of tabs from left side
     * @return list, that includes item itself and all it's children all level
     */
    private String printMenu(Item item, int tabs) {
        StringBuilder result = new StringBuilder();
        if (item.getNn() != 0) {
            result
                    .append(System.lineSeparator())
                    .append("\t".repeat(tabs - 1))
                    .append(item.getFullName());
        }
        for (Item itemMenu : item.getChildren()) {
            result
                    .append(this.printMenu(itemMenu, tabs + 1));
        }
        return result.toString();
    }
}
