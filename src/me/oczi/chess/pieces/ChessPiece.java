package me.oczi.chess.pieces;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessTable;

/**
 * A Chess piece representation for the {@link ChessTable}.
 */
public interface ChessPiece {

  void setId(String id);

  /**
   * Get ID of Chess Piece.
   * @return ID of Piece.
   */
  String getId();

  /**
   * Get the type of Chess piece.
   * @return Type of Chess piece.
   */
  ChessPieceType getType();

  /**
   * Get all the possible moves of Chess piece.
   * NOTE: This not process the obstacles.
   * @return all the possibles moves.
   */
  ChessLocation[] getPossibleMoves();
}
