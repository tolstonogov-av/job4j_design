package ru.job4j.menu;

import org.junit.Test;
import ru.job4j.menu.actions.CalcSumAction;
import ru.job4j.menu.actions.PrintMessageAction;
import ru.job4j.menu.actions.SimpleAction;
import ru.job4j.menu.items.*;

import static org.junit.Assert.*;

/**
 * Class to test class {@link MenuTasks}.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class MenuTasksTest {

    /**
     * Item1 1.
     * 	Item11 1.1.
     * 	Item12 1.2.
     * Item2 2.
     * 	Item21 2.1.
     * 		Item211 2.1.1.
     * 		Item212 2.1.2.
     * 	Item22 2.2.
     */
    @Test
    public void whenMenuCreatedAndShownThenPrintEntireMenu() {
        Item item1 = new ItemMenuSimple("Item1", 1, new SimpleAction());
        ItemActionWithoutParameters item11 = new ItemMenuPrintMessage("Item11", 1, new PrintMessageAction());
        ItemActionWithParameters item12 = new ItemMenuCalcSum("Item12", 2, new CalcSumAction());
        Item item2 = new ItemMenuSimple("Item2", 2, new SimpleAction());
        ItemActionWithoutParameters item21 = new ItemMenuPrintMessage("Item21", 1, new PrintMessageAction());
        ItemActionWithoutParameters item211 = new ItemMenuPrintMessage("Item211", 1, new PrintMessageAction());
        ItemActionWithParameters item212 = new ItemMenuCalcSum("Item212", 2, new CalcSumAction());
        ItemActionWithParameters item22 = new ItemMenuCalcSum("Item22", 2, new CalcSumAction());
        Menu menu = new MenuTasks();
        menu.addChild(item1);
        menu.addChild(item1, item11);
        menu.addChild(item1, item12);
        menu.addChild(item2);
        menu.addChild(item2, item21);
        menu.addChild(item21, item211);
        menu.addChild(item21, item212);
        menu.addChild(item2, item22);
        String expected = "Item1 1." + System.lineSeparator()
                + "\tItem11 1.1." + System.lineSeparator()
                + "\tItem12 1.2." + System.lineSeparator()
                + "Item2 2." + System.lineSeparator()
                + "\tItem21 2.1." + System.lineSeparator()
                + "\t\tItem211 2.1.1." + System.lineSeparator()
                + "\t\tItem212 2.1.2." + System.lineSeparator()
                + "\tItem22 2.2.";
        assertEquals(expected, menu.showMenu());
    }
}