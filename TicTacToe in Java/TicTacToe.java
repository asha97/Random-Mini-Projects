
import java.util.*;

public class TicTacToe {

    static String[] boardShape;
    static String turnTracker;

    static String checkWinner()
    {
        String line = null;
        for (int i = 0; i < 8; i++) {

            if(i==0)
                line = boardShape[0] + boardShape[1] + boardShape[2];
            else if (i==1)
                line = boardShape[3] + boardShape[4] + boardShape[5];
            else if (i==2)
                line = boardShape[6] + boardShape[7] + boardShape[8];
            else if (i==3)
                line = boardShape[0] + boardShape[3] + boardShape[6];
            else if (i==4)
                line = boardShape[1] + boardShape[4] + boardShape[7];
            else if (i==5)
                line = boardShape[2] + boardShape[5] + boardShape[8];
            else if (i==6)
                line = boardShape[0] + boardShape[4] + boardShape[8];
            else if (i==7)
                line = boardShape[2] + boardShape[4] + boardShape[6];

        }
        //check if x winning
        if (line.equals("XXX")) {
            return "X";
        }
        //check if 0 winning
        else if (line.equals("OOO")) {
            return "O";
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(boardShape).contains(
                    String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }

        // prompt to write turn
        System.out.println("it is the turn of " + turnTracker);
        System.out.println("Please enter a number in which you want to place your move: ");

        //return nothing
        return null;
    }

    // printing the board with numbers
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + boardShape[0] + " | " + boardShape[1] + " | " + boardShape[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardShape[3] + " | " + boardShape[4] + " | " + boardShape[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardShape[6] + " | " + boardShape[7] + " | " + boardShape[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args)
    {
        //prompt for user
        Scanner in = new Scanner(System.in);
        boardShape = new String[9];
        turnTracker = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            boardShape[a] = String.valueOf(a + 1);
        }

        System.out.println("This is Tic Tac Toe. The board looks like this: ");
        printBoard();

        System.out.println("X goes first ");
        System.out.println("Enter number where you want to place your move: ");

        while (winner == null) {
            int userMoveInput;

            // userMoveInput will be between 1 and 9.
            try {
                userMoveInput = in.nextInt();
                if (!(userMoveInput > 0 && userMoveInput <= 9)) {
                    System.out.println(
                            "Invalid! Please re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid! Please re-enter slot number:");
                continue;
            }

            //which player turn
            if (boardShape[userMoveInput - 1].equals(String.valueOf(userMoveInput)))
            {
                boardShape[userMoveInput - 1] = turnTracker;

                if (turnTracker.equals("X")) {
                    turnTracker = "O";
                    winner = checkWinner();
                } else {
                    turnTracker = "X";
                    winner = checkWinner();
                }
                printBoard();

            }
            else {
                System.out.println("Slot taken! Re-enter slot number:");
            }
        }

        // in case there is no winner or when there is a winner
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw!");
        } else {
            System.out.println(winner + "has won the game!! Congratulations.");
        }
        in.close();
    }
}

