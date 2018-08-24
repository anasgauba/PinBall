import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created a x and a y position for the mouse.
 * Added a MouseEvent to make sure the mouse moves
 * and gets the x and y coordinates.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Mouse {
    private double x;
    private double y;

    /**
     * Keeps track of the mouse position using EventHandler.
     * @return the mouse position
     */
    public EventHandler<MouseEvent> getMouseMovedHandler () {
        return event -> {
            x = event.getX ();
            y = event.getY ();
        };
    }

    /**
     * @return x position of the mouse.
     */
    public double getX () {
        return x;
    }
    /**
     * @return y position of the mouse.
     */
    public double getY () {
        return y;
    }
}
