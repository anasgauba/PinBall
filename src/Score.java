/**
 * Score class to keep track of the score.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Score {
    private int score;

    /**
     * Initially, constructing an empty
     * scoreboard object.
     */
    public Score() {
        reset();
    }

    /**
     * Prints a score.
     * @return current score.
     */
    public String toString() {
        return "" + score;
    }

    /**
     * Resets the score to 0.
     */
    public void reset() {
        this.score = 0;
    }

    /**
     * @return the current value of the score.
     */
    public int getCurrentValue() {
        return this.score;
    }

    /**
     * Adding points to the score.
     * @param value
     * @return incremented value.
     */
    public int incrementBy(int value) {
        return this.score += value;
    }
}
