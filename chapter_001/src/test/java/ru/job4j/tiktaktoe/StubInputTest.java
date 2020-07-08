package ru.job4j.tiktaktoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for test class StubInput.
 *
 * @see StubInput
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class StubInputTest {

    @Test
    public void ask() {
        String[] answers = {"answer1", "answer2"};
        Input stubInput = new StubInput(answers);
        String expected1 = answers[0];
        String expected2 = answers[1];
        assertEquals(expected1, stubInput.ask("", null));
        assertEquals(expected2, stubInput.ask("", null));
    }
}