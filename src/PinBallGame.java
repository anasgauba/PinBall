import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import sun.security.provider.certpath.SunCertPathBuilder;

import java.awt.*;

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

    public int getBoardWidth() {
        return 0;
    }
    public int getBoardHeight() {
        return 0;
    }
    public int getBoardRows() {
        return 0;
    }
    public int getBoardColumns() {
        return 0;
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle ("PinBall Machine Game");

        Group group = new Group();
        BorderPane pane = new BorderPane();
        Rectangle rect = new Rectangle(50, 50);
//        HBox hBox = new HBox();
        GameBoard gameBoard = new GameBoard();
        Score score = new Score();

//        pane.setPrefHeight(400);
//        pane.setPrefWidth(300);
        int width1 = 50;
        int height1 = 50;

        System.out.println(gameBoard);
        System.out.println("Score is " + score);

        int width = gameBoard.getWidth();
        int height = gameBoard.getHeight();
        int pixelWidth = (int)rect.getWidth();
        int pixelHeight = (int)rect.getHeight();
        System.out.println("Pixels " + pixelWidth);
        int tileSize = 0;
        rect.setFill(Color.BLACK);
        // rect.fillRect(0,0,pixelWidth, pixelHeight);

        System.out.println("pixelHeight is " + pixelHeight);
        if (pixelWidth < pixelHeight) {
            tileSize = pixelWidth / width;
        }
        else {
            tileSize = pixelHeight / height;
        }
        System.out.println("TileSize is " + tileSize);
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
                    rectBlue.setFill(Color.BLUE);
//                    Line verticalLine = new Line(xi, yi, width1,height1);
//                    verticalLine.setStroke(Color.BLACK);
                    pane.getChildren().add(rectBlue);
//                    pane.getChildren().add(verticalLine);
//                    System.out.println(currentWidth + " blue");
                    // rect.fillRect(currentWidth * tileSize, currentHeight * tileSize, tileSize, tileSize);
                    break;
                case GameBoard.YELLOW_TILE:
                    Rectangle rectYellow = new Rectangle(xi,yi,width1,height1);
                    xi += 50;
                    rectYellow.setFill(Color.YELLOW);
//                    Line line2 = new Line(xi, yi, width1, height1);
//                    line2.setStroke(Color.BLACK);
                    pane.getChildren().add(rectYellow);
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
        int xLine = 0;
        int yLine = 0;
        for (int i = 0; i < 4; i++) {
            xLine += 50;
            Line verticalLine = new Line();
            verticalLine.setStartX(xLine);
            verticalLine.setStartY(yLine);
            verticalLine.setEndX(xLine);
            verticalLine.setEndY(400);
            verticalLine.setStroke(Color.BLACK);
            pane.getChildren().add(verticalLine);
        }
        xLine = 0;
        for (int i = 0; i < 7; i++) {
            yLine += 50;
            Line horizontalLine = new Line();
            horizontalLine.setStartX(xLine);
            horizontalLine.setStartY(yLine);
            horizontalLine.setEndX(250);
            horizontalLine.setEndY(yLine);
            horizontalLine.setStroke(Color.BLACK);
            pane.getChildren().add(horizontalLine);
        }

//        pane.setPrefSize(200, 500);

        group.getChildren().add(pane);
        primaryStage.setScene(new Scene(group, 250, 500));
        primaryStage.show();
    }
}
