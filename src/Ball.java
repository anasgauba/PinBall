import java.util.Random;
import static java.lang.Math.*;

/**
 * Ball class to make the ball start at a specified
 * location, make the ball move.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Ball {

    Display display;
    Mouse mouse;
    private double xCoord;
    private double yCoord;
    Random random = new Random();
    public double angle = Math.toRadians(random.nextInt(240 ) + 30);

    /**
     * Ball object has access to display and mouse
     * to make the ball move and display.
     * @param display
     * @param mouse
     */
    public Ball(Display display, Mouse mouse) {
        this.display = display;
        this.mouse = mouse;
    }

    /**
     * Moves the ball in random direction.
     * Uses trig to figure out the deltaX (xOffset) and deltaY (yOffset)
     * Randomly generates an angle for the ball to move. Checks if we are
     * in play, change the x and y coordinates. Checks the bounds and flips
     * the sign of the offsets if ball touches left or right, down or up.
     * Changes the angle based on the bounds.
     *
     * @param pixels the factor by which ball moves
     */
    public void move(double pixels) {
        double xOffSet = pixels*cos(angle);
        double yOffSet = pixels*sin(angle);
        this.xCoord = display.ball.getCenterX();
        this.yCoord = display.ball.getCenterY();
        if (setInPlay()) {

            xCoord += xOffSet;
            yCoord += yOffSet;

            if (xCoord - display.ball.getRadius() <= 0 || xCoord + display.ball.getRadius() >= display.anchorPane.getWidth()) {
                xOffSet *= -1;
                angle = acos(xOffSet / pixels);
                if (xOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }
            }
            if (yCoord - display.ball.getRadius() <= 0 || yCoord + display.ball.getRadius() >= display.anchorPane.getHeight()) {
                yOffSet *= -1;
//                angle = asin(xOffSet / pixels);

                if (yOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }
            }
        }
        display.setBallAt(xCoord, yCoord);
    }

    /**
     * gets the currentLocation of the ball.
     */
    public void getLocation() {
        display.ball.getCenterX();
        display.ball.getCenterY();
    }

    /**
     * Checks for in play.
     * @return true/false if the button is disabled
     */
    public boolean setInPlay() {
        if (display.play.isDisabled()) {
            return true;
        }
        return false;
    }

    /**
     * Checks for in reset.
     * @return true/false if the button is disabled
     */
    public boolean setOffPlay() {
        if (display.reset.isDisabled()) {
            return true;
        }
        return false;
    }

    /**
     * Sets the start location at the center of the screen.
     * Triggers if the user is not in play.
     * Has a event handler to move the ball left and right.
     */
    public void setStartLocation() {
        if (setOffPlay()) {
            display.setBallAt(125, 410);
            display.ball.setOnMouseMoved(mouse.getMouseMovedHandler());
            display.ball.setCenterX(mouse.getX());
        }
    }
}
