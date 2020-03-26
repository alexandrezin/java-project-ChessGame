package application;


import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.exceptions.BoardException;
import chess.ChessMatch;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class Program {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			ChessMatch match = new ChessMatch();
			match.initialSetup();
			UI.printBoard(match.getPieces());
			int x=0;
			while(x<5) {
				System.out.println("Selecione a peca que deseja mover");
				ChessPosition sourcePosition = UI.readChessPosition(sc);
				System.out.println("Selecione para onde deseja mover");
				ChessPosition targetPosition = UI.readChessPosition(sc);
				
				System.out.println(match.performChessMove(sourcePosition, targetPosition));
				
				UI.printBoard(match.getPieces());
				
			}
			
		}
		catch(BoardException exception) {
			System.out.println(exception.getMessage());
		}
		catch(ChessException exception) {
			System.out.println(exception.getMessage());
		}
		catch(InputMismatchException exception) {
			System.out.println(exception.getMessage());
		}
				
	}
}
 