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
    public static final char BLUE_TILE = 'B';
    public static final char YELLOW_TILE = 'Y';
    Random random = new Random();
    Display display;

    /**
     * Constructing a gameBoard object with empty spots.
     */
    public GameBoard() {
        gameBoard = new char[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                gameBoard[row][col] = BLUE_TILE;
            }
        }
        randomize();
    }

    /**
     * Printing the gameBoard as 8x5.
     *
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
     *
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
    }


    /**
     * Passed in the ball's location for the board
     * to detect touch. Ball's coordinates might be huge, so
     * we need to divide it by rows and col to find the location of the
     * ball on the board. If the ball is in the location where
     * there's yellow tile, we need to replace it with blue tile.
     *
     * @param x ball's x coordinates
     * @param y ball's y coordinates
     * @return
     */
    public int touch(double x, double y) {
        if (gameBoard[(int) (y / NUM_ROWS)][(int) (x / NUM_COLS)] == YELLOW_TILE) {
            System.out.println(x);
            System.out.println(y);
            gameBoard[(int) (y / NUM_ROWS)][(int) (x / NUM_COLS)] = BLUE_TILE;
            return 1;
        }
        return 0;
    }

}
