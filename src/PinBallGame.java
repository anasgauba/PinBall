import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Random;

/**
 * PinBall game coordinator class. A parent class
 * that has access of its children classes such as
 * GameBoard, Ball, GameControls, and Score. It also
 * has access to display class so that we can layout some javafx
 * together.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class PinBallGame extends Application {
    /**
     * Launches the game.
     * @param args arguments
     */
    public static void main(String[]args) {
        launch(args);
    }
    /**
     * Instantiate all classes, animation timer, ActionListener for the buttons.
     * Sets up the animation for the ball to move.
     * Otherwise, sents the ball to the center.
     * ActionListeners for the play and reset button. Styled the buttons
     * and for the reset button pressed, hides the button, gameBoard resets and
     * play button enables.
     * @param primaryStage - displays it on the screen.
     */
    @Override
    public void start(Stage primaryStage) {
        GameBoard gameBoard = new GameBoard();
        Mouse mouse = new Mouse();
        Display display = new Display(primaryStage, gameBoard);
        GameControls gameControls = new GameControls(display, mouse);
        Ball ball = new Ball(display, mouse);
        Score score = new Score(display);

        AnimationTimer animationTimer = new AnimationTimer() {
            private long nextTime = 0;
            @Override
            public void handle(long now) {
                if (now > nextTime) {
                    if (gameControls.getMode()) {
                        ball.move(10);
                    }
                    else {
                        ball.setStartLocation();
                    }
//                    if (gameBoard.touch(display.ball.getCenterX(), display.ball.getCenterY()) == 1){
//                        score.incrementBy(10);
//                    }
                }

            }
        };
        animationTimer.start();

        display.play.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                display.setPlayButton(true);
                display.setReset(false);
                display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
                display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
            }
        });
        display.reset.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random random = new Random();
                ball.angle = Math.toRadians(random.nextInt(240 ) + 30);
                gameBoard.reset();
                display.drawGameBoard(gameBoard);
                display.setPlayButton(false);
                display.setReset(true);
                display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
                display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
            }
        });
    }
}
