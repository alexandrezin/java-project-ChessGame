package application;

import chess.ChessPiece;
import chess.Color;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	private static final String BOARDCOLOR = ANSI_CYAN;
	private static final String BLACK_PIECES_COLOR = ANSI_RED;
	private static final String WHITE_PIECES_COLOR = ANSI_WHITE;

	public static void printBoard(ChessPiece[][] pieces) {
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
}
