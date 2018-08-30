import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

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
    public void getMode() {
//        display.setPlayButton(false);

        display.setReset(true);
        display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
        display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
        display.play.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Clicked play");
                display.setPlayButton(true);
                display.setReset(false);
                display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
                display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
            }
        });
        display.reset.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Clicked reset");
                display.setPlayButton(false);
                display.setReset(true);
                display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
                display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
            }
        });
        //Tile have x and y, color, getters, setters.
        //make buttons here. if the button is pressed, true
    }
}
