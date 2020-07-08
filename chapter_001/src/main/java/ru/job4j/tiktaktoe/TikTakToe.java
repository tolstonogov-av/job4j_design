package ru.job4j.tiktaktoe;

/**
 * Class for tik-tak-toe.
 *
 * @author Tolstonogov Alexey
 * @version 1.0
 */
public class TikTakToe implements Game {

    /**
     * Inputs value for determines the human.
     */
    private static final String SIGN_HUMAN = "h";

    /**
     * Sign for determines of draw result.
     */
    private static final char SIGN_DRAW = 'D';

    /**
     * Sign for determines player X.
     */
    private static final char SIGN_X = 'X';

    /**
     * Sign for determines player O.
     */
    private static final char SIGN_0 = 'O';

    /**
     * First player of game.
     */
    private Player firstPlayer;

    /**
     * Second player of game.
     */
    private Player secondPlayer;

    /**
     * Player, which will be move.
     */
    private Player nextMovePlayer;

    /**
     * Board of game.
     */
    private Board board;

    /**
     * Length of win sequence.
     */
    private int lengthWin;

    /**
     * Logic for analyze the board.
     */
    private final Logic logic = new AnalyzeGame();

    /**
     * Result of game.
     */
    private Result result;

    /**
     * Determines input from human. For testing.
     */
    private final Input humanInput;

    public TikTakToe(Input humanInput) {
        this.humanInput = humanInput;
        this.initGame();
    }

    @Override
    public void start() {
        this.result = this.doGame();
        this.printResult();
    }

    /**
     * Initializes the game: size of board, length of win sequence, what players will participate in game.
     */
    private void initGame() {
        this.board = new GameBoard(Integer.parseInt(this.humanInput.ask("Please, input size of board (int):", null)));
        this.lengthWin = Integer.parseInt(this.humanInput.ask("Please, input length sequence of win (int):", null));
        System.out.println(this.board.printBoard());
        this.initPlayers();
        this.setNextMovePlayer(this.firstPlayer);
    }

    /**
     * Determines, what players will participate in game.
     */
    private void initPlayers() {
        String players = humanInput.ask("Please, input players - (h)uman or (c)omputer (e.g., \"h h\" or \"h c\")", null);
        String[] playersArray = players.split(" ");
        if (SIGN_HUMAN.equals(playersArray[0])) {
            this.firstPlayer = new GamePlayer(this.humanInput, SIGN_X);
        } else {
            this.firstPlayer = new GamePlayer(new ComputerInput(), SIGN_X);
        }
        if (SIGN_HUMAN.equals(playersArray[1])) {
            this.secondPlayer = new GamePlayer(this.humanInput, SIGN_0);
        } else {
            this.secondPlayer = new GamePlayer(new ComputerInput(), SIGN_0);
        }
    }

    public Result getResult() {
        return this.result;
    }

    private void setNextMovePlayer(Player player) {
        this.nextMovePlayer = player;
    }

    /**
     * Implements the process of game.
     *
     * @return result of game
     */
    private Result doGame() {
        Result result;
        do {
            this.board.setSign(this.nextMovePlayer.getSign(), this.doMove(this.nextMovePlayer));
            System.out.println(this.board.printBoard());
            this.nextMovePlayer = this.nextMovePlayer.equals(this.firstPlayer) ? this.secondPlayer : this.firstPlayer;
            result = this.logic.analyzeBoard(this.board, this.lengthWin);
        } while (result.getSign() == 0);
        return result;
    }

    /**
     * Prints the result of game.
     */
    private void printResult() {
        if (this.result.getSign() == SIGN_DRAW) {
            System.out.println("Draw!");
        } else {
            System.out.println("Player " + this.result.getSign() + " win!");
        }
    }

    /**
     * Gives command to the player to move.
     *
     * @param player player, who is given command
     * @return result of move - coordinate of field
     */
    private Coordinate doMove(Player player) {
        Coordinate result;
        do {
            System.out.print(player.getSign() + ", ");
            result = player.move(this.board);
        } while (!this.logic.analyzePossibleMove(this.board, result));
        this.board.setSign(player.getSign(), result);
        return result;
    }

    public static void main(String[] args) {
        Game game = new TikTakToe(new PlayerInput());
        game.start();
    }
}
