package calculator;

import java.util.Scanner;

/**
 * Handles users input.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ConsoleInput implements Input {
    /**
     * Scanner of input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Returns entered value.
     *
     * @param question Prompt to enter
     * @return Entered value
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
