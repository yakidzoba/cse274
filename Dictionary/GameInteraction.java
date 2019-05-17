import java.util.Scanner;

public class GameInteraction {

	public static void main(String[] args) {

		Board board = new Board();	
		
		System.out.println("Enter a number from 0-8 where you would like to play. You are X and the computer is O.\n");

		String newGame = "";

		do {
			// Happens while game is in progress
			while (board.getStatus() == Board.IN_PROGRESS) {

				// Human always goes first
				board = humanMove(board);

				// If human wins
				if (board.getStatus() == Board.X_WINS) {
					System.out.println("You won!");
					System.out.println(board.printBoard());
				}

				// If draw
				else if (board.getStatus() == Board.DRAW) {
					System.out.println("It is a draw");
					System.out.println(board.printBoard());
				}

				// If game still playing and computer's turn
				else {
					board = computerMove(board);

					// If computer wins
					if (board.getStatus() == Board.O_WINS) {
						System.out.println("Computer wins");
						System.out.println(board.printBoard());
					}

					if (board.getStatus() == Board.DRAW) {
						System.out.println("It is a draw");
						System.out.println(board.printBoard());
					}
				}
			}

			Scanner sc = new Scanner(System.in);
			System.out.println("Want to play again? (y/n)");
			newGame = sc.next();
			newGame = newGame.toLowerCase();

			if (newGame.equals("y")) {
				board.reset();
			}

		} while (newGame.equals("y"));

	} // end main

	/**
	 * A method that makes a move for the human
	 * @param board - the board to make the move on
	 * @return - the board after the move has been made
	 */
	public static Board humanMove(Board board) {
		// Shows board to human user
		System.out.println(board.printBoard());
		
		// Gets human's input (0-8)
		Scanner sc = new Scanner(System.in);

		// Variable to store the desired move position in
		int humanPos;

		do {
			System.out.println("Enter your move: ");
			humanPos = sc.nextInt();

			// If desired position is outside the legal range of 0-8 an error message will be displayed
			if (humanPos < 0 || humanPos > 8) {
				System.out.println("This is an illegal board position. Please enter a number from 0-8.");
			} 
			// If desired position is not empty, an error message will be displayed
			else if (board.isEmpty(humanPos) == false) {
				System.out.println("This position is not available.");
			}
			System.out.println("You played " + humanPos);
		} while (humanPos < 0 || humanPos > 8 || (board.isEmpty(humanPos) == false));

		// Makes and prints the human user's move
		board.makeMove("X", humanPos);
		System.out.println(board.printBoard());
		return board;
	}

	/**
	 * A method that randomly makes a move for the computer
	 * @param board
	 * @return
	 */
	public static Board computerMove(Board board) {
		int compMove = (int) (9*Math.random());
		
		while(!board.isEmpty(compMove)) {
			compMove = (int) (9*Math.random());
		}
		
		board.makeMove("O", compMove);
		System.out.println("Computer playes: " + compMove);
		return board;
	}

}
