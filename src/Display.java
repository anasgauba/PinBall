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
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Display {
 // pass the reference to the instance


    public Display(VBox vBox) {
        drawGameBoard(vBox);
        drawFloor(vBox);
        drawButtons(vBox);

    }

    public void drawGameBoard(VBox vBox) {
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

    public void drawFloor(VBox vBox) {
        Rectangle rectangle =  new Rectangle(0, 400, 250, 20);
        rectangle.setFill(Color.GRAY);
        vBox.getChildren().add(rectangle);
    }

    public void drawButtons(VBox vBox) {
        Score score = new Score();
        HBox hBox = new HBox();
        Button reset = new Button("reset");
        Button play = new Button("play");
        Label scoreLabel = new Label(score.toString());

        reset.setStyle("-fx-font: 22 arial; -fx-font-weight: bold;");
        play.setStyle("-fx-font: 22 arial; -fx-font-weight: bold;");
        scoreLabel.setStyle("-fx-background-color: black");
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setAlignment(Pos.CENTER);

        reset.setPrefSize(100, 40);
        play.setPrefSize(100, 40);
        scoreLabel.setPrefSize(50, 40);

        hBox.getChildren().add(reset);
        hBox.getChildren().add(scoreLabel);
        hBox.getChildren().add(play);
        vBox.getChildren().add(hBox);
    }
}
