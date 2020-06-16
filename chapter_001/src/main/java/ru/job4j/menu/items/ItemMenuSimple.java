package ru.job4j.menu.items;

import ru.job4j.menu.actions.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Class for simple item with simple action.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ItemMenuSimple implements Item {

    /**
     * Name of item.
     */
    private final String name;

    /**
     * Number in order od item in current level.
     */
    private final int nn;

    /**
     * Parent item of current item.
     */
    private Item parent;

    /**
     * List of children of current item.
     */
    private final List<Item> children = new LinkedList<>();

    /**
     * Action, which perform current item.
     */
    private final Action action;

    public ItemMenuSimple(String name, int nn, Action action) {
        this.name = name;
        this.nn = nn;
        this.action = action;
    }

    @Override
    public int getNn() {
        return this.nn;
    }

    /**
     * Returns the full number of item - all numbers from each level.
     *
     * @return the full number of item
     */
    private String getFullNn() {
        StringBuilder result = new StringBuilder();
        result
                .append(getNn())
                .append('.');
        Item parent = this.parent;
        while (parent != null && parent.getNn() != 0) {
            result
                    .insert(0, '.')
                    .insert(0, parent.getNn());
            parent = parent.getParent();
        }
        return result.toString();
    }

    @Override
    public String getFullName() {
        return this.getName() + ' ' + this.getFullNn();
    }

    private String getName() {
        return this.name;
    }

    @Override
    public List<Item> getChildren() {
        return this.children;
    }

    @Override
    public void setParent(Item parent) {
        this.parent = parent;
    }

    @Override
    public Item getParent() {
        return this.parent;
    }

    @Override
    public void addChild(Item item) {
        item.setParent(this);
        this.children.add(item);
    }

    @Override
    public String doAction() {
        return this.action.getNameOperation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemMenuSimple itemMenuSimple = (ItemMenuSimple) o;
        return nn == itemMenuSimple.nn
                && Objects.equals(parent, itemMenuSimple.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nn, parent);
    }
}
