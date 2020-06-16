package ru.job4j.menu.actions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test class {@link CalcSumAction}.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class CalcSumActionTest {

    /**
     * Action to test.
     */
    private final ActionWithParameters actionWithParameters = new CalcSumAction();

    /**
     * Checks result of simple action.
     */
    @Test
    public void whenGetNameOperationActionThenReturnNameOperation() {
        String expected = "Calculation of sum";
        assertEquals(expected, actionWithParameters.getNameOperation());
    }

    /**
     * Checks result of sum.
     */
    @Test
    public void whenCalcSumActionThenReturnCalcSum() {
        int expected = 7;
        assertEquals(expected, actionWithParameters.actionWithParameters(5, 2));
    }
}