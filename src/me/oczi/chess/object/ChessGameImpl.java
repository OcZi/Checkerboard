package me.oczi.chess.object;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.location.ChessLocationImpl;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.utils.ChessPreconditions;
import me.oczi.chess.utils.MoreChess;

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
    return arrayTable.length == 0
        ? null
        : arrayTable[x][y];
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
    checkAvailableIds(piece);
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[x][y] = piece;
  }

  private void checkAvailableIds(ChessPiece piece) {
    // Create cycle to check if piece Id
    int i = 0;
    String nextId = piece.getId();
    while (true) {
      ++i;
      if (i == 10) {
        checkAlphabeticAvailableIds(piece);
        break;
      }
      ChessPiece pieceWithId = getPieceWithId(nextId);
      if (pieceWithId == null) {
        piece.setId(nextId);
        break;
      }
      nextId = piece.getId() + i;
    }
  }

  private void checkAlphabeticAvailableIds(ChessPiece piece) {
    char[] alphabetic = MoreChess.alphabetic;
    int alphaLength = alphabetic.length;
    int i = 0;
    String nextId;
    while (true) {
      if (alphaLength - 1 < i) {
        throw new IllegalStateException(
            "Cannot assign an ID for the piece. No ids available.");
      }
      char c = alphabetic[i++];
      nextId = piece.getId() + c;
      ChessPiece pieceWithId = getPieceWithId(nextId);
      if (pieceWithId == null) {
        piece.setId(nextId);
        break;
      }
    }
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
