import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

/**
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Ball {

    private double x;
    private double y;
    private double angle = Math.toDegrees(45);
//    private boolean isPlaying = true;
    Display display;
    Mouse mouse;

    /**
     *
     */
    public Ball(Display display, Mouse mouse) {
        this.display = display;
        this.mouse = mouse;
    }

    /**
     *
     */
    public void reset() {

    }

    public void move(double pixels) {
        double xOffSet = pixels*cos(angle);
        double yOffSet = pixels*sin(angle);
        if (setInPlay()) {
            x += xOffSet;
            y += yOffSet;

        }
    }

    public void getLocation() {

    }

    public boolean setInPlay() {
        return true;
    }

    public boolean setOffPlay() {
        return false;
    }

    public void setStartLocaton() {
        Mouse mouse = new Mouse();
        if (setOffPlay()) {
            mouse.getMouseMovedHandler();
        }
    }
}
