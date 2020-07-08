package ru.job4j.tiktaktoe;

/**
 * Interface for inputs.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public interface Input {

    /**
     * Asks the question.
     *
     * @param question question
     * @param board board, that is the subject of question
     * @return answer
     */
    String ask(String question, Board board);
}
