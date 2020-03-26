package boardgame;

import boardgame.exceptions.BoardException;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) throws BoardException{
		if (rows < 1 || columns < 1) {
			throw new BoardException("The number of columns and rows has to be greater than 0");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[this.rows][this.columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	//positionExistsMethod
	private boolean positionExistsMethod (int row, int column) {
		if (row>this.rows || row<0 || column>this.columns || column<0) {
			return false;
		}
		return true;
	}
	
	public boolean positionExists (Position position) {
		return positionExistsMethod(position.getRow(), position.getColumn());
	}
	
	public boolean positionExists (int row, int column) {
		return positionExistsMethod(row, column);
	}
	
	//thereIsAPieceMethod
	private boolean thereIsAPieceMethod(int row, int column) {
		return pieces[row][column] != null;
	}
	
	public boolean thereIsAPiece(Position position) {
		return thereIsAPieceMethod(position.getRow(),position.getColumn());
	}
	
	public boolean thereIsAPiece(int row, int column) {
		return thereIsAPieceMethod(row,column);
	}
	
	//Get Piece
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("This position does not exist: " +row + " " + column);
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position does not exist: " +position.getRow() + " " + position.getColumn());
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Place a Piece
	public void placePiece(Piece piece, Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position does not exist: " +position.getRow() + " " + position.getColumn());
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}	
	
	//Remove a Piece
	public Piece removePiece(Position position) {
		if (!positionExists(position.getRow(), position.getColumn())) {
			throw new BoardException("This position does not exist: " + position.getRow() + " " + position.getColumn());
		}
		if (piece(position) == null) {
			throw new BoardException("There is no piece at this position: " + position.getRow() + " " + position.getColumn());
		}
		Piece aux = piece(position);
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
}
