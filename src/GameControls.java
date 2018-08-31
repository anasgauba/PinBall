/**
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class GameControls {

    Display display;
    Mouse mouse = new Mouse();

    /**
     *
     */
    public GameControls(Display display, Mouse mouse) {
        this.display = display;
        this.mouse = mouse;
    }

    /**
     *
     * @return
     */
    public boolean getMode() {
        if (display.play.isDisabled()) {
            return true;
        }
        return false;
//        display.play.setOnMousePressed(mouse.getMouseMovedHandler());
//        display.setPlayButton(false);

//        display.setReset(true);
//        display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
//        display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");

        //Tile have x and y, color, getters, setters.
        //make buttons here. if the button is pressed, true
    }
}
