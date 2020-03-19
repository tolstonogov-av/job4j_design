package ru.job4j.template;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Map;

/**
 * Class for testing class GeneratorPhrases.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class GeneratorTest {
    /**
     * The template to generate a phrase.
     */
    private final String template = "I am a ${name}, Who are ${subject}?";

    /**
     * "I am a ${name}, Who are ${subject}?"
     *         Alex             ?
     * ->
     * IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void deficitElement() {
        Generator generator = new GeneratorPhrases();
        Map<String, Object> args = Map.of("name", "Alex");
        String result = generator.produce(template, args);
    }

    /**
     * "I am a ${name}, Who are ${subject}?"
     *         Alex             you       redundant
     * ->
     * IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void redundancyElement() {
        Generator generator = new GeneratorPhrases();
        Map<String, Object> args = Map.of("name", "Alex", "subject", "you", "argument", "redundant");
        String result = generator.produce(template, args);
    }

    /**
     * "I am a ${name}, Who are ${subject}?"
     *         Alex             you
     * ->
     * "I am a Alex, Who are you?"
     */
    @Test
    public void produce() {
        Generator generator = new GeneratorPhrases();
        Map<String, Object> args = Map.of("name", "Alex", "subject", "you");
        String result = generator.produce(template, args);
        String expected = "I am a Alex, Who are you?";
        assertEquals(expected, result);
    }
}
