package me.oczi.chess.object;

import me.oczi.chess.ChessPreconditions;
import me.oczi.chess.pieces.ChessPiece;

/**
 * Basic implementation of {@link ChessTable}.
 */
public class ChessTableImpl implements ChessTable {
  // Array 2D as table.
  private final ChessPiece[][] arrayTable;

  ChessTableImpl() {
    // 8x8 dimensions.
    this(new ChessPiece[8][8]);
  }

  ChessTableImpl(ChessPiece[][] arrayTable) {
    this.arrayTable = arrayTable;
  }

  @Override
  public ChessPiece getPieceAt(int x, int y) {
    // Yep, just a array accessor.
    return arrayTable[x][y];
  }

  @Override
  public void newPiece(int x, int y, ChessPiece piece) {
    // If
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[--x][--y] = piece;
  }

  @Override
  public ChessPiece[][] getArrayTable() {
    return arrayTable;
  }
}
