package ru.job4j.tiktaktoe;

import java.util.List;
import java.util.Random;

/**
 * Class for input of computer.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class ComputerInput implements Input {

    private final Random random = new Random();

    @Override
    public String ask(String question, Board board) {
        System.out.println(question);
        Coordinate coordinate = this.getRandomCoordinate(board.getEmptyFields());
        return coordinate.getX() + ", " + coordinate.getY();
    }

    /**
     * Calculates the random coordinate of list of coordinates.
     *
     * @param coordinates coordinates for selecting
     * @return selected random coordinate
     */
    private Coordinate getRandomCoordinate(List<Coordinate> coordinates) {
        return coordinates.get(random.nextInt(coordinates.size()));
    }
}