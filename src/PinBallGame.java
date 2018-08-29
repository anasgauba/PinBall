import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

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
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        Display display = new Display(vBox);

        primaryStage.setTitle ("PinBall Machine Game");
        primaryStage.setScene(new Scene(vBox, 250, 460));
        primaryStage.show();
    }
}
