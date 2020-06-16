package ru.job4j.menu.items;

import org.junit.Test;
import ru.job4j.menu.actions.PrintMessageAction;
import ru.job4j.menu.actions.SimpleAction;

import static org.junit.Assert.*;

public class ItemMenuPrintMessageTest {

    @Test
    public void whenWithoutParentsThenPrintFullNameWithoutTheirNn() {
        ItemActionWithoutParameters item1 = new ItemMenuPrintMessage("Level 1", 1, new PrintMessageAction());
        String expected = "Level 1 1.";
        assertEquals(expected, item1.getFullName());
    }

    @Test
    public void whenExist2LevelParentsThenPrintFullNameWithTheirNn() {
        ItemActionWithoutParameters item1 = new ItemMenuPrintMessage("Level 1", 1, new PrintMessageAction());
        ItemActionWithoutParameters item2 = new ItemMenuPrintMessage("Level 2", 1, new PrintMessageAction());
        ItemActionWithoutParameters item3 = new ItemMenuPrintMessage("Level 3", 1, new PrintMessageAction());
        item1.addChild(item2);
        item2.addChild(item3);
        String expected = "Level 3 1.1.1.";
        assertEquals(expected, item3.getFullName());
    }

    @Test
    public void whenDoActionThenReturnNameOperation() {
        ItemActionWithoutParameters item1 = new ItemMenuPrintMessage("Level 1", 1, new PrintMessageAction());
        String expected = "Print \"Hello\"";
        assertEquals(expected, item1.doAction());
    }

    @Test
    public void whenDoActionWithoutParametersThenReturnMessage() {
        ItemActionWithoutParameters item1 = new ItemMenuPrintMessage("Level 1", 1, new PrintMessageAction());
        String expected = "Hello.";
        assertEquals(expected, item1.doActionWithoutParameters());
    }
}
