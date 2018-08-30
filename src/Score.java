/**
 * Score class to keep track of the score.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Score {
    private int score;
    Display display;

    /**
     * Initially, constructing an empty
     * scoreboard object.
     */
    public Score(Display display) {
        reset();
        this.display = display;
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
    public void incrementBy(int value) {
        this.score += value;
        display.setScore(value);

    }
}
