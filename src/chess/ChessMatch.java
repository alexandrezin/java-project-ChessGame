package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;

public class ChessMatch {
	
	Board board;

	public ChessMatch(){
		this.board = new Board(8, 8);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] chessPiece = new ChessPiece[board.getRows()][board.getColumns()];
		for (int row=0; row<board.getRows(); row++) {
			for (int column = 0; column<board.getColumns(); column ++) {
				chessPiece[row][column] = (ChessPiece) board.piece(row, column);
			}
		}
		return chessPiece; 
	}
	
	public void initialSetup() {
		//White King
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		
	}
}
