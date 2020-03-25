package application;

import boardgame.exceptions.BoardException;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		try {
			ChessMatch match = new ChessMatch();
			match.initialSetup();
			UI.printBoard(match.getPieces());
		}
		catch(BoardException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
 