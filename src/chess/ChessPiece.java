package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public abstract boolean[][] possibleMoves();

	protected boolean isThereOpponentPiece(Position p) {
		ChessPiece piece = (ChessPiece) getBoard().piece(p);
		return piece != null && piece.getColor() != color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	public Color getColor() {
		return color;
	}
	
}
