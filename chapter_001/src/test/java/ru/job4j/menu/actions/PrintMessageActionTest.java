package ru.job4j.menu.actions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test class {@link PrintMessageAction}.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class PrintMessageActionTest {

    /**
     * Action to test.
     */
    private final ActionWithoutParameters actionWithoutParameters = new PrintMessageAction();

    /**
     * Checks result of simple action.
     */
    @Test
    public void whenGetNameOperationActionThenReturnNameOperation() {
        String expected = "Print \"Hello\"";
        assertEquals(expected, actionWithoutParameters.getNameOperation());
    }

    /**
     * Checks result of returning message.
     */
    @Test
    public void whenPrintMessageActionThenReturnMessage() {
        String expected = "Hello.";
        assertEquals(expected, actionWithoutParameters.actionWithoutParameters());
    }
}