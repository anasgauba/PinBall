import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Random;

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
        GameBoard gameBoard = new GameBoard();
        Mouse mouse = new Mouse();
        Display display = new Display(primaryStage, gameBoard);
        GameControls gameControls = new GameControls(display, mouse);
        Ball ball = new Ball(display, mouse);
        Score score = new Score(display);
//        Ball ball = new Ball();
//        Score score = new Score();
//        ball.setStartLocation();
        AnimationTimer animationTimer = new AnimationTimer() {
            private long nextTime = 0;
            @Override
            public void handle(long now) {
                if (now > nextTime) {
//                    ball.setStartLocation();
                    if (gameControls.getMode()) {
                        ball.move(1);
                    }
                    else {
                        ball.setStartLocation();
                    }

                }

            }
        };
        animationTimer.start();
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
                Random random = new Random();
                ball.angle = Math.toRadians(random.nextInt(0 + 1 + 150) - 150);;
                gameBoard.reset();
                display.drawGameBoard(gameBoard);
                display.setPlayButton(false);
                display.setReset(true);
                ball.setStartLocation();
                display.play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
                display.reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
            }
        });
    }
}
