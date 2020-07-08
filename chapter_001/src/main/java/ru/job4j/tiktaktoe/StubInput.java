package ru.job4j.tiktaktoe;

/**
 * Class for stub input for testing.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class StubInput implements Input {

    /**
     * Sequence of values for input.
     */
    private final String[] answers;

    /**
     * Index of next answer.
     */
    private int nextAnswer;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question, Board board) {
        System.out.println(question);
        return this.answers[this.nextAnswer++];
    }
}
