import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * PinBall game coordinator class. A parent class
 * that has access of its children classes such as
 * GameBoard, Ball, GameControls, and Score.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class PinBallGame extends Application {

    public static void main(String[]args) {
        launch(args);
    }
    /**
     * instantiate all classes
     * animation timer
     */
    @Override
    public void start(Stage primaryStage) {
        Mouse mouse = new Mouse();
        Display display = new Display(primaryStage);
        GameControls gameControls = new GameControls(display, mouse);
        GameBoard gameBoard = new GameBoard();
        Ball ball = new Ball(display, mouse);
        Score score = new Score(display);
//        Ball ball = new Ball();
//        Score score = new Score();
        gameControls.getMode();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {


            }
        };
        animationTimer.start();
    }
}
