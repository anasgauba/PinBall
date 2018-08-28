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
        primaryStage.setTitle ("PinBall Machine Game");

        Group group = new Group();
        VBox vBox = new VBox();
//        BorderPane pane = new BorderPane();
        HBox hBox = new HBox();
        GameBoard gameBoard = new GameBoard();
        Score score = new Score();

//        pane.setPrefHeight(400);
//        pane.setPrefWidth(300);
        int width1 = 50;
        int height1 = 50;

        System.out.println(gameBoard);
        System.out.println("Score is " + score);

//        int width = gameBoard.getWidth();
//        int height = gameBoard.getHeight();
//        int pixelWidth = (int)rect.getWidth();
//        int pixelHeight = (int)rect.getHeight();
//        System.out.println("Pixels " + pixelWidth);
//        int tileSize = 0;
//        rect.setFill(Color.BLACK);
        // rect.fillRect(0,0,pixelWidth, pixelHeight);

//        System.out.println("pixelHeight is " + pixelHeight);
//        if (pixelWidth < pixelHeight) {
//            tileSize = pixelWidth / width;
//        }
//        else {
//            tileSize = pixelHeight / height;
//        }
//        System.out.println("TileSize is " + tileSize);
        char[] board = gameBoard.toString().toCharArray();
//        int currentWidth = 0;
//        int currentHeight = 0;
        int xi = 0;
        int yi = 0;

        for (int i = 0; i < board.length; i++) {
            switch (board[i]) {
                case GameBoard.BLUE_TILE:
                    Rectangle rectBlue = new Rectangle(xi,yi,width1,height1);
                    xi += 50;
                    rectBlue.setFill(Color.rgb(72, 103, 178));
                    rectBlue.setStroke(Color.rgb(48, 72, 132));
//                    Line verticalLine = new Line(xi, yi, width1,height1);
//                    verticalLine.setStroke(Color.BLACK);
                    group.getChildren().add(rectBlue);
//                    pane.getChildren().add(verticalLine);
//                    System.out.println(currentWidth + " blue");
                    // rect.fillRect(currentWidth * tileSize, currentHeight * tileSize, tileSize, tileSize);
                    break;
                case GameBoard.YELLOW_TILE:
                    Rectangle rectYellow = new Rectangle(xi,yi,width1,height1);
                    xi += 50;
                    rectYellow.setFill(Color.rgb(252, 194, 0));
                    rectYellow.setStroke(Color.rgb(48, 72, 132));
//                    Line line2 = new Line(xi, yi, width1, height1);
//                    line2.setStroke(Color.BLACK);
                    group.getChildren().add(rectYellow);
//                    pane.getChildren().add(line2);

//                    System.out.println(GameBoard.YELLOW_TILE);
//                    System.out.println(currentWidth + " yellow ");
                    //rect.fillRect(currentWidth * tileSize, currentHeight * tileSize, tileSize, tileSize);
                    break;

                case '\n':
//                    currentWidth = -1;
//                    currentHeight++;
                    yi += 50;
                    xi = 0;

                    width1 = 50;
                    height1 = 50;
//                    System.out.println(currentWidth + " " + currentHeight);
                    break;
                default:
                    return;
            }
//            currentWidth++;
        }



        Rectangle rectangle =  new Rectangle(0, 400, 250, 20);
        rectangle.setFill(Color.GRAY);

        Button reset = new Button("reset");
        Button play = new Button("play");
        Label scoreLabel = new Label("000");

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
        /**
         * instantiate all classes
         * animation timer
         *
         */
//        pane.setPrefSize(250, 500);

        vBox.getChildren().add(group);
//        vBox.getChildren().add(Ball);
//        pane.getChildren().add(rectangle);
//        vBox.getChildren().add(pane);
        vBox.getChildren().add(rectangle);
        vBox.getChildren().add(hBox);
//        pane.getChildren().add(rectangle);
//        pane.getChildren().add(hBox);
        primaryStage.setScene(new Scene(vBox, 250, 460));
        primaryStage.show();
    }
}
