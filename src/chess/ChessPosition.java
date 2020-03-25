package chess;

import boardgame.Position;

public class ChessPosition{
	int row;
	char column;
	//Position position;
	
	public ChessPosition(int row, char column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public Position toPosition(int row, char column) {
	 return new Position(row, charToInt(column));	
	}
	
	public ChessPosition fromPosition(Position position) {
		return new ChessPosition(position.getRow(), intToChar(position.getColumn()));
	}
	
	private int charToInt(char c) {
		return (int) c - 64;
	}
	
	private char intToChar(int i) {
		return (char)(i + 64);
	}
}
