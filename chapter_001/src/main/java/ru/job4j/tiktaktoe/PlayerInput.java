package ru.job4j.tiktaktoe;

import java.util.Scanner;

/**
 * Class for input of human.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class PlayerInput implements Input {

    /**
     * Scanner for manual input from console.
     */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question, Board board) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
