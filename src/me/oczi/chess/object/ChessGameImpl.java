package me.oczi.chess.object;

import me.oczi.chess.ChessPreconditions;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.location.ChessLocationImpl;
import me.oczi.chess.pieces.ChessPiece;

/**
 * Basic implementation of {@link ChessGame}.
 */
public class ChessGameImpl implements ChessGame {
  // Array 2D as table.
  private final ChessPiece[][] arrayTable;

  ChessGameImpl() {
    // 8x8 dimensions.
    this(new ChessPiece[8][8]);
  }

  ChessGameImpl(ChessPiece[][] arrayTable) {
    this.arrayTable = arrayTable;
  }

  @Override
  public ChessPiece getPieceAt(int x, int y) {
    // Yep, just a array accessor.
    if (arrayTable.length == 0) {
      return null;
    }
    return arrayTable[x][y];
  }

  @Override
  public ChessPiece getPieceWithId(String id) {
    for (ChessPiece[] chessPieces : arrayTable) {
      for (ChessPiece chessPiece : chessPieces) {
        if (chessPiece == null) continue;
        if (chessPiece.getId().equalsIgnoreCase(id)) {
          return chessPiece;
        }
      }
    }
    return null;
  }

  @Override
  public void putPiece(int x, int y, ChessPiece piece) {
    // Create cycle to check if piece Id
    int i = 0;
    String nextId = piece.getId();
    while (true) {
      ++i;
      ChessPiece pieceWithId = getPieceWithId(nextId);
      if (pieceWithId == null) {
        piece.setId(nextId);
        break;
      }
      nextId = piece.getId() + i;
    }
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[x][y] = piece;
  }

  @Override
  public void removePiece(ChessPiece piece) {
    // The same that putPiece()
    ChessLocation currentLocation = piece.getCurrentLocation();
    int x = currentLocation.getX();
    int y = currentLocation.getY();
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[x][y] = null;
  }

  @Override
  public void swapPiece(int x, int y, ChessPiece piece) {
    removePiece(piece);
    putPiece(x, y, piece);
    piece.setCurrentLocation(new ChessLocationImpl(x, y));
  }

  @Override
  public ChessPiece[][] getArrayTable() {
    return arrayTable;
  }
}
