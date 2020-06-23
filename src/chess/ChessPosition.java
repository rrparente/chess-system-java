package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private Integer row;
	
	public ChessPosition(char column, Integer row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8)
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public Integer getRow() {
		return row;
	}
	
	//TODO protected
	public Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position p) {
		return new ChessPosition((char)('a' + p.getColumn()), 8 - p.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
