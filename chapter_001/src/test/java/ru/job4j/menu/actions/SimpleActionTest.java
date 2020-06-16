package ru.job4j.menu.actions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test class {@link SimpleAction}.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class SimpleActionTest {

    /**
     * Action to test.
     */
    private final Action simpleAction = new SimpleAction();

    /**
     * Checks result of simple action.
     */
    @Test
    public void whenGetNameOperationActionThenReturnNameOperation() {
        String expected = "Simple Action";
        assertEquals(expected, simpleAction.getNameOperation());
    }
}