package calculator;

import java.util.Iterator;
import java.util.List;

/**
 * Realizes substitution of answers from user.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class StubInput implements Input {
    /**
     * Iterator contains choice menu option.
     */
    private final Iterator<String> iterator;

    /**
     * Constructor of StubInput object.
     *
     * @param answers List containing answers
     */
    public StubInput(final List<String> answers) {
        this.iterator = answers.iterator();
    }

    /**
     * Realizes substitution of the next answer the question.
     *
     * @param question Question
     * @return Answer from iterator
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        String answer = iterator.next();
        System.out.println(answer);
        return answer;
    }
}