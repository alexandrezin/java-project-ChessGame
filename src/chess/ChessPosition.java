package chess;

import boardgame.Position;
import chess.exceptions.ChessException;

public class ChessPosition{
	int row;
	char column;
	//Position position;
	
	public ChessPosition(int row, char column) throws ChessException{
		if (column < 'A' || column > 'H' || row < 1 || row > 8) {
			throw new ChessException("This position does not exist");
		}
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}

	public Position toPosition() {
	 return new Position(this.row - 1, charToInt(this.column) - 1);	
	}
	
	public static ChessPosition fromPosition(Position position) {
		return new ChessPosition(position.getRow() + 1, intToChar(position.getColumn()));
	}
	
	public int charToInt(char c) {
		return (int) c - 64;
	}
	
	public static char intToChar(int i) {
		return (char)(i + 64);
	}
	
	@Override
	public String toString(){ 
		return "" + this.column + this.row;
	}
}
