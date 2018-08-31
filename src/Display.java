import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
//    Pane group = new Pane();
    AnchorPane anchorPane = new AnchorPane();
    VBox vBox = new VBox();
    Circle ball = new Circle();
    public Button reset = new Button("reset");
    public Button play = new Button("play");
    Label scoreLabel = new Label();

    Rectangle grayBar =  new Rectangle(0, 400, 250, 20);
    Rectangle rectBlue;
    Rectangle rectYellow;

//    int boardWidth = 215;
//    int boardHeight = 400;
//    int boardRows = 8;
//    int boardCols = 5;
//    char[][] gameBoard;
//    public final char BLUE_TILE = '.';
//    public final char YELLOW_TILE = 'Y';
//
//    public int getBoardWidth() {
//        return  boardWidth;
//    }
//
//    public int getBoardHeight() {
//        return boardHeight;
//    }
//
//    public int getBoardRows() {
//        return boardRows;
//    }
//
//    public int getBoardCols() {
//        return boardCols;
//    }


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
                    anchorPane.getChildren().add(rectBlue);
                    break;
                case GameBoard.YELLOW_TILE:
                    Rectangle rectYellow = new Rectangle(xi, yi, width1, height1);
                    xi += 50;
                    rectYellow.setFill(Color.rgb(252, 194, 0));
                    rectYellow.setStroke(Color.rgb(48, 72, 132));
                    anchorPane.getChildren().add(rectYellow);
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
//        vBox.getChildren().add(anchorPane);
    }

    public void drawFloor() {
//        Canvas canvas = new Canvas(250, 20);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.fillRect(0, 400, 250, 20);
//        gc.setFill(Color.BLUE);
//        ball.setCenterX(125);
//        ball.setCenterY(410);
        ball.setRadius(10);
        ball.setFill(Color.RED);
        grayBar.setFill(Color.GRAY);
//        vBox.getChildren().add(canvas);
//        anchorPane.getChildren().add(canvas);
        anchorPane.getChildren().addAll(grayBar, ball);
        vBox.getChildren().add(anchorPane);
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

    public void setBallAt(double centerX, double centerY) {
        ball.setCenterX(centerX);
        ball.setCenterY(centerY);

    }

    public void drawButtons() {
//        GameControls gameControls = new GameControls();
//        Score score = new Score();
        HBox hBox = new HBox();
        reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: gray");
        play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold; -fx-background-color: yellow");
        setReset(true);

        reset.setPrefSize(100, 40);
        play.setPrefSize(100, 40);
        scoreLabel.setPrefSize(50, 40);

        hBox.getChildren().add(reset);
        hBox.getChildren().add(scoreLabel);
        hBox.getChildren().add(play);
        vBox.getChildren().add(hBox);
    }
}
