import java.util.Random;

/**
 * A class to create a gameBoard.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class GameBoard {
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 5;
    public char[][] gameBoard;
    public static final char BLUE_TILE = '.';
    public static final char YELLOW_TILE = 'Y';
//    public static final char WALL_REP = 'X';
    Random random = new Random();
    Display display;

    /**
     * Constructing a gameBoard object with empty spots.
     */
    public GameBoard() {
//        this.display = display;
        gameBoard = new char[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                gameBoard[row][col] = BLUE_TILE;
            }
        }
        randomize();
//        display.drawGameBoard();

    }

    /**
     * Printing the gameBoard as 8x5.
     * @return the gameBoard.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {
                str.append(gameBoard[r][c]);
            }
            str.append('\n');
        }
        return str.toString();
    }
    /**
     * Randomly generate the Yellow Tile.
     * Grabs a random location of both row and col,
     * Checks if the intended location is blue then replace
     * it with yellow. Otherwise, keep looking for blue tile.
     */
    private void randomize() {
        int rowLocation = this.random.nextInt(NUM_ROWS - 2);
        int colLocation = this.random.nextInt(NUM_COLS);
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {
                if (gameBoard[rowLocation][colLocation] == BLUE_TILE) {
                    gameBoard[rowLocation][colLocation] = YELLOW_TILE;
                    rowLocation = this.random.nextInt(NUM_ROWS - 2);
                    colLocation = this.random.nextInt(NUM_COLS);
                }
                if (gameBoard[rowLocation][colLocation] == YELLOW_TILE) {
                    gameBoard[rowLocation][colLocation] = BLUE_TILE;
                    rowLocation = this.random.nextInt(NUM_ROWS - 2);
                    colLocation = this.random.nextInt(NUM_COLS);
                }

            }
        }
    }

    /**
     * Resets the board, upon reclicking, it shuffles the tiles.
     */
    public void reset() {
        randomize();
        System.out.println(this);
//        display.drawGameBoard(this);

    }

    /**
     *
     * @param x
     * @param y
     */
    public void touch(int x, int y) {


    }

}
