package me.oczi.chess.deprecated;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Unused implementation of {@link ChessTeam}.
 */
public class ChessTeamImpl implements ChessTeam {
  private ChessPiece[] pieces;

  ChessTeamImpl() {
    pieces = new ChessPiece[8];
  }

  @Override
  public ChessPiece getPiece(String id) {
    for (ChessPiece piece : pieces) {
      if (piece == null) {
        System.out.println("is null");
        continue;
      }
      if (piece.getId().equalsIgnoreCase(id)) {
        return piece;
      }
    }

    return null;
  }

  @Override
  public void addPiece(ChessPiece piece) {
    if (hasPieceWithId(piece.getId())) {
      int i = 0;
      while (true) {
        i++;
        String nextId = piece.getType().getDefaultId() + i;
        if (!hasPieceWithId(nextId)) {
          piece.setId(nextId);
          break;
        }
      }
    }

    piece.setId(piece.getId().toLowerCase());
    ChessPiece[] newPieces = new ChessPiece[pieces.length + 1];
    newPieces[pieces.length] = piece;
    this.pieces = newPieces;
  }

  @Override
  public void removePiece(ChessPiece piece) {
    ChessPiece[] newPieces = new ChessPiece[pieces.length - 1];
    for (int i = 0; i < pieces.length; i++) {
      ChessPiece p = pieces[i];
      if (p == null) {
        continue;
      }
      if (!p.getId().equalsIgnoreCase(piece.getId())) {
        newPieces[i] = pieces[i];
      }
    }
    this.pieces = newPieces;
  }

  @Override
  public boolean hasPieceWithId(String id) {
    return getPiece(id) != null;
  }

  @Override
  public ChessPiece[] getPieces() {
    return pieces;
  }
}
