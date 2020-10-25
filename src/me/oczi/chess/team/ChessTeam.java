package me.oczi.chess.team;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Chess team for the player.
 */
public interface ChessTeam {

  /**
   * Create a new team.
   * @return new team.
   */
  static ChessTeam newTeam() {
    return new ChessTeamImpl();
  }

  /**
   * Get piece of chess by id.
   * @param id
   * @return
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
}
