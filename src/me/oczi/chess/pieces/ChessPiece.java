package me.oczi.chess.pieces;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.types.ChessPieceType;

/**
 * A Chess piece representation for the {@link ChessGame}.
 */
public interface ChessPiece {

  /**
   * Set id of Chess piece.
   * @param id Id to set.
   */
  void setId(String id);

  /**
   * Set current location of Chess piece.
   * @param location Location to set.
   */
  void setCurrentLocation(ChessLocation location);

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
   * @return all the possibles moves.
   */
  ChessLocation[][] getPossibleMoves(ChessGame game);

  /**
   * Get current Location of Chess piece.
   * @return Location of chess.
   */
  ChessLocation getCurrentLocation();

  boolean hasFreedomMove();
}
