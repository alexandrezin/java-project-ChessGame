package chess;

import boardgame.Board;
import boardgame.Position;
import chess.exceptions.ChessException;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	private Color currentPlayer;

	public ChessMatch(){
		this.board = new Board(8, 8);
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
		currentPlayer = Color.WHITE;
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
	
	private boolean checkSourcePiece(ChessPiece sourcePiece) {
		if (sourcePiece.getColor() != currentPlayer) {
			return false;
		}
		return true;
	}
	
	private boolean checkTargetPiece(ChessPiece targetPiece) {
		if (targetPiece == null) {
			return true;
		}
		if (targetPiece.getColor() == currentPlayer) {
			return false;
		}
		return true;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) throws ChessException{
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		if (!board.thereIsAPiece(source)) {
			throw new ChessException("There is no piece at this position");
		}
		
		ChessPiece sourcePiece = (ChessPiece)board.piece(source);
		ChessPiece targetPiece = (ChessPiece)board.piece(target);
	
		if (!checkSourcePiece(sourcePiece)){
			throw new ChessException("This piece belongs to the other Player");
		}
		
		if (!checkTargetPiece(targetPiece)) {
			throw new ChessException("It's not possible to capture your own piece");
		}
				
		board.removePiece(source);
		board.placePiece(sourcePiece, targetPosition.toPosition());
		
		return targetPiece;
	}
}
