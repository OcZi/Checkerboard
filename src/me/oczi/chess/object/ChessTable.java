package me.oczi.chess.object;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Chess's Table representation.
 */
public interface ChessTable {

  static ChessTable newBasicTable() {
    return new ChessTableImpl();
  }

  /**
   * Get piece at position X and Y of Table.
   * @param x X axis.
   * @param y Y axis.
   * @return ChessPiece or null.
   */
  ChessPiece getPieceAt(int x, int y);

  void newPiece(int x, int y, ChessPiece piece);

  /**
   * Get Array 2D of table.
   * @return A ChessPiece array of two dimensions.
   */
  ChessPiece[][] getArrayTable();
}
