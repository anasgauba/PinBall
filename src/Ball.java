import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

/**
 * Ball class to make the ball start at a specified
 * location, make the ball move.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Ball {

    Display display;
    Mouse mouse;
    private double x;
    private double y;
    private double angle = Math.toDegrees(-0.785398163);
//    private boolean isPlaying = true;

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
//
//    public void reset() {
//        display.ball.setCenterX(20);
//        display.ball.setCenterX(20);
//        display.ball.setRadius(10);
//    }

    /**
     *
     * @param pixels
     */
    public void move(double pixels) {
        double xOffSet = pixels*cos(angle);
        double yOffSet = pixels*sin(angle);
        x = display.ball.getCenterX();
        y = display.ball.getCenterY();
        if (setInPlay()) {
            System.out.println("getting x val " + display.ball.getCenterX());
            System.out.println("getting y val " + display.ball.getCenterY());
            System.out.println("x before" + x);

            x += xOffSet;
            y += yOffSet;

            if (x + display.ball.getRadius() <= 0 || x + display.ball.getRadius() >= display.anchorPane.getWidth()) {
                System.out.println("Width of the window is " + display.anchorPane.getWidth());
                System.out.println("xOffset is " + xOffSet);
                xOffSet += -1;
                System.out.println("xOffset after is " + xOffSet);

            }
            if (y + display.ball.getRadius() <= 0 || y + display.ball.getRadius() >= display.anchorPane.getHeight()) {
                System.out.println("Height of the window is " + display.anchorPane.getHeight());
                yOffSet += -1;
            }

            System.out.println("ball x " + x);
            System.out.println("ball y " + y);
        }
        display.setBallAt(x, y);
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
