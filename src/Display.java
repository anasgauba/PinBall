import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Display {
 // pass the reference to the instance
    StackPane pane = new StackPane();
    VBox vBox = new VBox();
    Circle ball = new Circle();
    public Button reset = new Button("reset");
    public Button play = new Button("play");
    Label scoreLabel = new Label();


    public Display(Stage primaryStage) {
        drawGameBoard();
        drawFloor();
        drawButtons();
        setScore(0);
        primaryStage.setTitle ("PinBall Machine Game");
        primaryStage.setScene(new Scene(vBox, 250, 460));
        primaryStage.show();
    }

    public void drawGameBoard() {
        Group group = new Group();
        GameBoard gameBoard = new GameBoard();
        int xi = 0;
        int yi = 0;
        int width1 = 50;
        int height1 = 50;
        char[] board = gameBoard.toString().toCharArray();

        for (char aBoard : board) {
            switch (aBoard) {
                case GameBoard.BLUE_TILE:
                    Rectangle rectBlue = new Rectangle(xi, yi, width1, height1);
                    xi += 50;
                    rectBlue.setFill(Color.rgb(72, 103, 178));
                    rectBlue.setStroke(Color.rgb(48, 72, 132));
                    group.getChildren().add(rectBlue);
                    break;
                case GameBoard.YELLOW_TILE:
                    Rectangle rectYellow = new Rectangle(xi, yi, width1, height1);
                    xi += 50;
                    rectYellow.setFill(Color.rgb(252, 194, 0));
                    rectYellow.setStroke(Color.rgb(48, 72, 132));
                    group.getChildren().add(rectYellow);
                    break;

                case '\n':
                    yi += 50;
                    xi = 0;

                    width1 = 50;
                    height1 = 50;
                    break;
                default:
                    return;
            }
        }
        vBox.getChildren().add(group);
    }

    public void drawFloor() {
//        Canvas canvas = new Canvas(250, 20);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
        Rectangle rectangle =  new Rectangle(0, 400, 250, 20);
//        gc.fillRect(0, 400, 250, 20);
//        gc.setFill(Color.BLUE);
        ball.setCenterX(20);
        ball.setCenterY(20);
        ball.setRadius(10);
        ball.setFill(Color.RED);
        rectangle.setFill(Color.GRAY);
//        vBox.getChildren().add(canvas);
//        pane.getChildren().add(canvas);
        pane.getChildren().addAll(rectangle, ball);
        vBox.getChildren().add(pane);
    }

    public void setScore(int value) {
        scoreLabel.setText(String.valueOf(value));
        scoreLabel.setStyle("-fx-background-color: black");
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setAlignment(Pos.CENTER);

    }

    public void setPlayButton(boolean state) {
        play.setDisable(state);
    }

    public void setReset(boolean state) {
        reset.setDisable(state);
    }

    public void drawButtons() {
//        GameControls gameControls = new GameControls();
//        Score score = new Score();
        HBox hBox = new HBox();

//        reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
//        play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold;");

        reset.setPrefSize(100, 40);
        play.setPrefSize(100, 40);
        scoreLabel.setPrefSize(50, 40);

        hBox.getChildren().add(reset);
        hBox.getChildren().add(scoreLabel);
        hBox.getChildren().add(play);
        vBox.getChildren().add(hBox);
    }
}
