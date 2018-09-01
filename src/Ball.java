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
        setStartLocation();
    }

    /**
     *
     * @param pixels ball speed.
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
                if (xOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }
            }
            if (yCoord - display.ball.getRadius() <= 0 || yCoord + display.ball.getRadius() >= display.anchorPane.getHeight()) {
                yOffSet *= -1;
                if (xOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }
            }
        }
        display.setBallAt(xCoord, yCoord);
    }

    public void getLocation() {
        display.ball.getCenterX();
        display.ball.getCenterY();
    }

    public boolean setInPlay() {
        if (display.play.isDisabled()) {
            return true;
        }
        return false;
    }

    public boolean setOffPlay() {
        if (display.reset.isDisabled()) {
            return true;
        }
        return false;
    }

    public void setStartLocation() {
        if (setOffPlay()) {
            display.setBallAt(125, 410);
            display.ball.setOnMouseMoved(mouse.getMouseMovedHandler());
            display.ball.setCenterX(mouse.getX());
        }
    }
}
