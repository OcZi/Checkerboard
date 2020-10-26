package me.oczi.chess.object.deprecated;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Chess team for the player.
 * Deprecated for desync arrays with the Chess Table.
 * And will never be an another team
 * for now.
 */
@Deprecated
public interface ChessTeam {

  /**
   * Get piece of chess by id.
   * @param id ID of the chess.
   * @return piece by id, or null.
   */
  ChessPiece getPiece(String id);

  /**
   * Add a new Chess piece
   * @param piece Piece to add.
   */
  void addPiece(ChessPiece piece);

  /**
   * Remove a Chess piece.
   * @param piece Piece to remove.
   */
  void removePiece(ChessPiece piece);

  /**
   * Check if a id is already in the Chess piece array.
   * @param id Id to check.
   * @return Is present or not.
   */
  boolean hasPieceWithId(String id);

  /**
   * Get all the pieces of the team.
   * @return Team's pieces.
   */
  ChessPiece[] getPieces();
}
