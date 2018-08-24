import javafx.application.Application;
import javafx.stage.Stage;

/**
 * PinBall game cooridnator class. A parent class
 * that has access of its children classes such as
 * GameBoard, Ball, GameControls, and Score.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class PinBallGame extends Application {

    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle ("PinBall Machine Game");
        primaryStage.show();
    }
}
