package boardgame;

public class Board {

	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1)
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public Piece piece(Integer row, Integer column) {
		if(!positionExists(row, column))
			throw new BoardException("Position not on the board");
		return pieces[row][column];
	}
	
	public Piece piece(Position pos) {
		if(!positionExists(pos))
			throw new BoardException("Position not on the board");
		return pieces[pos.getRow()][pos.getColumn()];
	}

	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position))
			throw new BoardException("There is already a piece on position " + position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position p) {
		if(!positionExists(p))
			throw new BoardException("Position not on the board");
		if(piece(p) == null)
			return null;
		Piece x = piece(p);
		x.position = null;
		pieces[p.getRow()][p.getColumn()] = null;
		return x;
	}
	
	public boolean positionExists(Position p) {
		return positionExists(p.getRow(), p.getColumn());
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean thereIsAPiece(Position p) {
		if(!positionExists(p))
			throw new BoardException("Position not on the board");
		return piece(p) != null;
	}
	
	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
}