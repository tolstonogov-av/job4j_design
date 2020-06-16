package ru.job4j.menu.items;

import org.junit.Test;
import ru.job4j.menu.actions.CalcSumAction;
import ru.job4j.menu.actions.PrintMessageAction;

import static org.junit.Assert.*;

public class ItemMenuCalcSumTest {

    @Test
    public void whenWithoutParentsThenPrintFullNameWithoutTheirNn() {
        ItemActionWithParameters item1 = new ItemMenuCalcSum("Level 1", 1, new CalcSumAction());
        String expected = "Level 1 1.";
        assertEquals(expected, item1.getFullName());
    }

    @Test
    public void whenExist2LevelParentsThenPrintFullNameWithTheirNn() {
        ItemActionWithParameters item1 = new ItemMenuCalcSum("Level 1", 1, new CalcSumAction());
        ItemActionWithParameters item2 = new ItemMenuCalcSum("Level 2", 1, new CalcSumAction());
        ItemActionWithParameters item3 = new ItemMenuCalcSum("Level 3", 1, new CalcSumAction());
        item1.addChild(item2);
        item2.addChild(item3);
        String expected = "Level 3 1.1.1.";
        assertEquals(expected, item3.getFullName());
    }

    @Test
    public void whenDoActionThenReturnNameOperation() {
        ItemActionWithParameters item1 = new ItemMenuCalcSum("Level 1", 1, new CalcSumAction());
        String expected = "Calculation of sum";
        assertEquals(expected, item1.doAction());
    }

    @Test
    public void whenDoActionWithParametersThenReturnSum() {
        ItemActionWithParameters item1 = new ItemMenuCalcSum("Level 1", 1, new CalcSumAction());
        int expected = 12;
        assertEquals(expected, item1.doActionWithParameters(5, 7));
    }
}