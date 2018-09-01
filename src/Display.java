import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Javafx class to display the game. Draws a gameboard, grayBar for
 * the ball, and sets the buttons and label. Used vBox as a root
 * node to display vertically. Used anchorPane for the board and grayBar.
 * Used hbox to layout the buttons and scoreLabel.
 *
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Display {
    VBox vBox = new VBox();
    AnchorPane anchorPane = new AnchorPane();
    Circle ball = new Circle();
    public Button reset = new Button("reset");
    public Button play = new Button("play");
    Label scoreLabel = new Label();

    Rectangle grayBar =  new Rectangle(0, 400, 250, 20);
    Rectangle rectBlue;
    Rectangle rectYellow;

    /**
     * A display object to show everything on the window.
     * Sets the preferred width and height of the window through
     * vBox (parent node).
     *
     * @param primaryStage displays it on the screen.
     * @param gameBoard the gameBoard
     */
    public Display(Stage primaryStage, GameBoard gameBoard) {
        drawGameBoard(gameBoard);
        drawFloor();
        drawButtons();
        setScore(0);
        primaryStage.setTitle ("PinBall Machine Game");
        primaryStage.setScene(new Scene(vBox, 250, 460));
        primaryStage.show();
    }

    /**
     * Draws the gameBoard. Adds the blue/yellow rectangles based on
     * the characters 'B', 'Y'. Loops through the board array and
     * draw the gameBoard. Adds the rectangle to anchorPane.
     *
     * @param gameBoard to draw the gameBoard.
     */
    public void drawGameBoard(GameBoard gameBoard) {
        int xi = 0;
        int yi = 0;
        int width1 = 50;
        int height1 = 50;
        char[] board = gameBoard.toString().toCharArray();

        for (char aBoard : board) {
            switch (aBoard) {
                case GameBoard.BLUE_TILE:
                    rectBlue = new Rectangle(xi, yi, width1, height1);
                    xi += 50;
                    rectBlue.setFill(Color.rgb(72, 103, 178));
                    rectBlue.setStroke(Color.rgb(48, 72, 132));
                    anchorPane.getChildren().add(rectBlue);
                    break;
                case GameBoard.YELLOW_TILE:
                    rectYellow = new Rectangle(xi, yi, width1, height1);
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
    }

    /**
     * Draws the grayBar with the ball in it.
     * Adds the rectangle and ball to anchorPane.
     */
    public void drawFloor() {
        ball.setRadius(10);
        ball.setFill(Color.RED);
        grayBar.setFill(Color.GRAY);
        anchorPane.getChildren().addAll(grayBar, ball);
        vBox.getChildren().add(anchorPane);
    }

    /**
     * Changes the label to the corresponding number.
     * Styles the scoreLabel.
     *
     * @param value the currentScore.
     */
    public void setScore(int value) {
        scoreLabel.setText(String.valueOf(value));
        scoreLabel.setStyle("-fx-background-color: black");
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setAlignment(Pos.CENTER);

    }

    /**
     * Resets the play button to either true or false.
     *
     * @param state true/false for reset button.
     */
    public void setPlayButton(boolean state) {
        play.setDisable(state);
    }

    /**
     * Resets the reset button to either true or false.
     *
     * @param state true/false for reset button.
     */
    public void setReset(boolean state) {
        reset.setDisable(state);
    }

    /**
     * Gets the x and y position of the ball.
     *
     * @param centerX xPosition of the ball.
     * @param centerY yPosition of the ball.
     */
    public void setBallAt(double centerX, double centerY) {
        ball.setCenterX(centerX);
        ball.setCenterY(centerY);
    }

    /**
     * Draws buttons play and reset, and draws a label
     * for score. Initially, the reset button is disabled.
     */
    public void drawButtons() {
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
