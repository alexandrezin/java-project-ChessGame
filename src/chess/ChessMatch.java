package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

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
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		ChessPosition chessPosition = new ChessPosition(row, column);
		board.placePiece(piece, chessPosition.toPosition());
	}
	public void initialSetup() {
		//WHITE Pieces------------
		//King
		placeNewPiece('E', 8, new King(board, Color.WHITE));
		//Rook
		placeNewPiece('A', 8, new Rook(board, Color.WHITE));
		placeNewPiece('H', 8, new Rook(board, Color.WHITE));
		
		//BLACK Pieces------------
		//King
		placeNewPiece('E', 1, new King(board, Color.BLACK));
		//Rook
		placeNewPiece('A', 1, new Rook(board, Color.BLACK));
		placeNewPiece('H', 1, new Rook(board, Color.BLACK));
	}
}
