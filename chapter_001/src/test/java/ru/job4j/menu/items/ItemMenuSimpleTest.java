package ru.job4j.menu.items;

import org.junit.Test;
import ru.job4j.menu.actions.SimpleAction;

import static org.junit.Assert.*;

public class ItemMenuSimpleTest {

    @Test
    public void whenWithoutParentsThenPrintFullNameWithoutTheirNn() {
        Item item1 = new ItemMenuSimple("Level 1", 1, new SimpleAction());
        String expected = "Level 1 1.";
        assertEquals(expected, item1.getFullName());
    }

    @Test
    public void whenExist2LevelParentsThenPrintFullNameWithTheirNn() {
        Item item1 = new ItemMenuSimple("Level 1", 1, new SimpleAction());
        Item item2 = new ItemMenuSimple("Level 2", 1, new SimpleAction());
        Item item3 = new ItemMenuSimple("Level 3", 1, new SimpleAction());
        item1.addChild(item2);
        item2.addChild(item3);
        String expected = "Level 3 1.1.1.";
        assertEquals(expected, item3.getFullName());
    }

    @Test
    public void whenDoActionThenReturnNameOperation() {
        Item item1 = new ItemMenuSimple("Level 1", 1, new SimpleAction());
        String expected = "Simple Action";
        assertEquals(expected, item1.doAction());
    }
}