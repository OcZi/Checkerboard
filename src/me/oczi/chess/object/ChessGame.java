package me.oczi.chess.object;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Chess's game with Table and team.
 */
public interface ChessGame {

  /**
   * Create a new game.
   * @return New game.
   */
  static ChessGame newBasicGame() {
    return new ChessGameImpl();
  }

  /**
   * Get piece at position X and Y of Table.
   * @param x X axis.
   * @param y Y axis.
   * @return ChessPiece or null.
   */
  ChessPiece getPieceAt(int x, int y);

  ChessPiece getPieceWithId(String id);

  /**
   * Put a new piece in the table.
   * @param x X axis.
   * @param y Y axis.
   * @param piece Piece to put.
   */
  void putPiece(int x, int y, ChessPiece piece);

  /**
   * Remove a piece in the table.
   * @param piece Piece to remove.
   */
  void removePiece(ChessPiece piece);

  void swapPiece(int x, int y, ChessPiece piece);

  /**
   * Get Array 2D of table.
   * @return A Chess table array of two dimensions.
   */
  ChessPiece[][] getArrayTable();
}
