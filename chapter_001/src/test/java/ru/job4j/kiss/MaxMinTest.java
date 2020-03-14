package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class to test class MaxMin.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class MaxMinTest {
    /**
     * The list of values.
     */
    private final List<String> list = List.of("Tolstonogov", "Mem", "Stenly");

    /**
     * The object of the MaxMin class.
     */
    private final MaxMin mm = new MaxMin();

    /**
     * Comparator, which compares strings depending of their length.
     */
    private final Comparator<String> comparator = Comparator.comparingInt(String::length);

    /**
     * Max length from ("Tolstonogov", "Mem", "Stenly") at "Tolstonogov".
     */
    @Test
    public void max() {
        String expected = "Tolstonogov";
        assertEquals(expected, mm.max(list, comparator));
    }

    /**
     * Max length from ("Tolstonogov", "Mem", "Stenly") at "Mem".
     */
    @Test
    public void min() {
        String expected = "Mem";
        assertEquals(expected, mm.min(list, comparator));
    }
}