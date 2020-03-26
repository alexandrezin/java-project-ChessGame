package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	//RESET
	public static final String ANSI_RESET = "\u001B[0m";
	
	//Text Colors
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	//Text Colors
	public static final String ANSI_BOLD_BLACK = "\033[1;30m";
	public static final String ANSI_BOLD_RED = "\033[1;31m";
	public static final String ANSI_BOLD_GREEN = "\033[1;32m";
	public static final String ANSI_BOLD_YELLOW = "\033[1;33m";
	public static final String ANSI_BOLD_BLUE = "\033[1;34m";
	public static final String ANSI_BOLD_PURPLE = "\033[1;35m";
	public static final String ANSI_BOLD_CYAN = "\033[1;36m";
	public static final String ANSI_BOLD_WHITE = "\033[1;37m";
	
	//Background Colors
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	private static final String BOARDCOLOR = ANSI_CYAN;
	private static final String BLACK_PIECES_COLOR = ANSI_BOLD_RED;
	private static final String WHITE_PIECES_COLOR = ANSI_BOLD_WHITE;

	public static void printBoard(ChessPiece[][] pieces) {
		System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	    
	    System.out.println("   XADREZin v1.0\n");
		System.out.println(BOARDCOLOR + "  A B C D E F G H" + ANSI_RESET);
		for (int row = 0; row < pieces.length; row++) {
			System.out.print(BOARDCOLOR);
			System.out.print(row + 1 + " ");
			System.out.print(ANSI_RESET);
			for (int column = 0; column < pieces.length; column++) {
				printPiece(pieces[row][column]);
			}
			System.out.print(BOARDCOLOR);
			System.out.print(row + 1);
			System.out.print(ANSI_RESET);
			System.out.println();
		}
		System.out.println(BOARDCOLOR + "  A B C D E F G H" + ANSI_RESET);
	}

	private static void printPiece(ChessPiece piece) {
		
		if (piece == null) {
			System.out.print(BOARDCOLOR + "." + ANSI_RESET);	
		} 

		else {
			if (piece.getColor() == Color.WHITE) {
                System.out.print(WHITE_PIECES_COLOR + piece + ANSI_RESET);
            }
			
            else {
                System.out.print(BLACK_PIECES_COLOR + piece + ANSI_RESET);
            }
		}

		System.out.print(" ");
	}
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String position = sc.nextLine();
			char column = position.charAt(0);
			int row = Integer.parseInt(position.substring(1));
			return new ChessPosition(row, column);
		}
		catch(RuntimeException exception) {
			throw new InputMismatchException("Wrong input format!");
		}
	}
}
