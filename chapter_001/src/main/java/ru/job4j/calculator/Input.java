package ru.job4j.calculator;

/**
 * Interface for input by user and by tests.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Input {
    /**
     * Returns entered value.
     * @param question Prompt to enter
     * @return Entered value
     */
    String ask(String question);
}
