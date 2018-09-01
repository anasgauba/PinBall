/**
 * A class to control the state of the game.
 * It has access to the display and mouse to get the mode
 * of the buttons.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class GameControls {

    Display display;
    Mouse mouse = new Mouse();

    /**
     * Controls object with an access to display and mouse.
     */
    public GameControls(Display display, Mouse mouse) {
        this.display = display;
        this.mouse = mouse;
    }

    /**
     * Checks for which mode the game is in.
     * @returns true/false based on the button disable.
     */
    public boolean getMode() {
        if (display.play.isDisabled()) {
            return true;
        }
        return false;
    }
}
