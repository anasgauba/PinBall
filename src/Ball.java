import java.util.Random;

import static java.lang.Math.*;

/**
 * Ball class to make the ball start at a specified
 * location, make the ball move.
 * @version date: 2018-08-24
 * @author Anas Farooq Gauba
 */
public class Ball {

    Display display;
    Mouse mouse;
    private double xCoord;
    private double yCoord;
    Random random = new Random();
    public double angle = Math.toRadians(random.nextInt(240 ) + 30);
//    public double angle = Math.toRadians(225);

//    private boolean isPlaying = true;

    /**
     * Ball object has access to display and mouse
     * to make the ball move and display.
     * @param display
     * @param mouse
     */
    public Ball(Display display, Mouse mouse) {
        this.display = display;
        this.mouse = mouse;
        setStartLocation();
    }
//
//    public void reset() {
//        display.ball.setCenterX(20);
//        display.ball.setCenterX(20);
//        display.ball.setRadius(10);
//    }

    /**
     *
     * @param pixels
     */
    public void move(double pixels) {
//        System.out.println("anchor pane " + display.anchorPane.getWidth());
//        System.out.println("angle is " + angle);
        double xOffSet = pixels*cos(angle);
        double yOffSet = pixels*sin(angle);
        this.xCoord = display.ball.getCenterX();
        this.yCoord = display.ball.getCenterY();
        if (setInPlay()) {
//            System.out.println("getting x val " + display.ball.getCenterX());
//            System.out.println("getting y val " + display.ball.getCenterY());
//            System.out.println("x before" + x);
//            System.out.println("xOffset before " + xOffSet);
//            System.out.println("yOffset before " + yOffSet);

//            xCoord += xOffSet;
//            yCoord += yOffSet;
            xCoord += xOffSet;
            yCoord += yOffSet;
            System.out.println("xOffset before " + xOffSet);
            System.out.println("yOffset before " + yOffSet);
            if (xCoord - display.ball.getRadius() <= 0 || xCoord + display.ball.getRadius() >= display.anchorPane.getWidth()) {
//                System.out.println("pane width is " + display.anchorPane.getWidth());
//                System.out.println("xOffset is " + xOffSet);
//                System.out.println("x is " + xCoord);
                xOffSet *= -1;
                System.out.println("xAngle before " + angle);
                if (xOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                    System.out.println("xAngle after " + angle);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }

//                System.out.println("xOffset after is " + xOffSet);
//                display.getBallX(x);

            }
            if (yCoord - display.ball.getRadius() <= 0 || yCoord + display.ball.getRadius() >= display.anchorPane.getHeight()) {
//                System.out.println("pane height is " + display.anchorPane.getHeight());
//                System.out.println("yOffset is " + yOffSet);
//                System.out.println("y is " + yCoord);
                yOffSet *= -1;
                System.out.println("yAngle before " + angle);
                if (xOffSet != 0) {
                    angle = tan(yOffSet / xOffSet);
                    System.out.println("yAngle after " + angle);
                }
                else {
                    angle = tan(yOffSet / xOffSet);
                }
//                System.out.println("yOffset after is " + yOffSet);
//                display.getBallY(y);
            }

            System.out.println("xOffset after " + xOffSet);
            System.out.println("yOffset after " + yOffSet);



//            System.out.println("ball x " + x);
//            System.out.println("ball y " + y);
        }
        display.setBallAt(xCoord, yCoord);
    }

    public void getLocation() {
        display.ball.getCenterX();
        display.ball.getCenterY();
    }

    public boolean setInPlay() {
        if (display.play.isDisabled()) {
            return true;
        }
        return false;
    }

    public boolean setOffPlay() {
        if (display.reset.isDisabled()) {
            return true;
        }
        return false;
    }

    public void setStartLocation() {
        if (setOffPlay()) {
            display.setBallAt(125, 410);
            display.ball.setOnMouseMoved(mouse.getMouseMovedHandler());
            display.ball.setCenterX(mouse.getX());
        }
    }
}
