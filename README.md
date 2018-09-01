PinBall Game:
 - PinballGame is the main entry point where the animation timer is.
 - Board draws random yellow tiles everytime the game starts.
 - There are two buttons play and reset and a label in between them.
 - if pressed play, the ball moves at a random direction, disables
   the play button, enables the reset button.
 - if pressed reset, the ball starts Location is center of the window.
   the board randomizes.

 Some Bugs:
  - When pressed reset, the board overloads the new board, therefore, the
    ball still moves on the previous gameBoard.
     -line 79  in PinBallGame.java : display.drawGameBoard(gameBoard);
        displays the board and OVERLOADS the old gameBoard.
        That's what changing the tiles.
  - The ball move is behaving weirdly, Its an an angle issue that I couldn't fix.
  - The touch(x, y) in GameBoard.java is giving ArrayOutOfBoundsException
     -Didn't get a chance to fix this issue, its an issue with the logic.
      I commented out the part (line 55-57) in PinBallGame.java which increments
      the score based on ball touching the yellow tiles.

 Things Not Implemented:
  - Do game over if the ball touches the boundary 3 times.
