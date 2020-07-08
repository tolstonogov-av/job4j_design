package ru.job4j.tiktaktoe;

/**
 * Class for realization logic of game.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class AnalyzeGame implements Logic {

    private static final char SIGN_DRAW = 'D';
    
    @Override
    public Result analyzeBoard(Board board, int lengthWin) {
        char sign;
        char[][] fields = this.getFields(board);
        sign = checkColumns(fields, lengthWin);
        if (sign == 0) {
            sign = checkRows(fields, lengthWin);
            if (sign == 0) {
                sign = checkDiagonals(fields, lengthWin);
            }
        }
        if (sign == 0 && board.getEmptyFields().size() == 0) {
            sign = SIGN_DRAW;
        }
        return new GameResult(sign);
    }

    @Override
    public boolean analyzePossibleMove(Board board, Coordinate coordinate) {
        return board.getSign(coordinate) == 0;
    }

    /**
     * Gets field from board.
     *
     * @param board board with fields
     * @return array char with sign in field
     */
    private char[][] getFields(Board board) {
        char[][] result = new char[board.getSize()][board.getSize()];
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                result[x][y] = board.getSign(new FieldCoordinate(x, y));
            }
        }
        return result;
    }

    /**
     * Checks columns of char[][] for win sequence.
     *
     * @param fields char[][]
     * @param lengthWin length of win sequence
     * @return char of win sequence
     */
    private char checkColumns(char[][] fields, int lengthWin) {
        char result = 0;
        for (char[] column : fields) {
            result = checkSequence(column, lengthWin);
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    /**
     * Checks rows of char[][] for win sequence.
     *
     * @param fields char[][]
     * @param lengthWin length of win sequence
     * @return char of win sequence
     */
    private char checkRows(char[][] fields, int lengthWin) {
        char[][] invertedFields = invertFields(fields);
        return checkColumns(invertedFields, lengthWin);
    }

    /**
     * Checks diagonals of char[][] for win sequence.
     *
     * @param fields char[][]
     * @param lengthWin length of win sequence
     * @return char of win sequence
     */
    private char checkDiagonals(char[][] fields, int lengthWin) {
        char result;
        char[] diagonal = new char[fields.length];
        for (int x = 0; x < fields.length; x++) {
            diagonal[x] = fields[x][x];
        }
        result = checkSequence(diagonal, lengthWin);
        if (result == 0) {
            for (int x = 0; x < fields.length; x++) {
                diagonal[x] = fields[x][fields.length - x - 1];
            }
            result = checkSequence(diagonal, lengthWin);
        }
        return result;
    }

    /**
     * Checks sequence of char for win sequence.
     *
     * @param sequence sequence to check
     * @param lengthWin length of win sequence
     * @return char of win sequence
     */
    private char checkSequence(char[] sequence, int lengthWin) {
        char result = 0;
        char checkedChar = 0;
        int checkedLength = 0;
        for (char c : sequence) {
            if (c != 0) {
                if (checkedChar != 0) {
                    if (c == checkedChar) {
                        checkedLength++;
                        if (checkedLength == lengthWin) {
                            result = c;
                            break;
                        }
                    } else {
                        checkedChar = c;
                        checkedLength = 1;
                    }
                } else {
                    checkedChar = c;
                    checkedLength = 1;
                }
            } else {
                checkedChar = 0;
                checkedLength = 0;
            }
        }
        return result;
    }

    /**
     * Inverts rows to columns and columns to rows of char[][].
     *
     * @param fields array to invert
     * @return inverted array
     */
    private char[][] invertFields(char[][] fields) {
        char[][] invertedFields = new char[fields.length][fields.length];
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields.length; y++) {
                invertedFields[x][y] = fields[y][x];
            }
        }
        return invertedFields;
    }
}
