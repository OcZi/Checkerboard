package me.oczi.chess.team;

import me.oczi.chess.pieces.ChessPiece;

public class ChessTeamImpl implements ChessTeam {
  private ChessPiece[] pieces;

  ChessTeamImpl() {
    pieces = new ChessPiece[]{};
  }

  @Override
  public ChessPiece getPiece(String id) {
    for (ChessPiece piece : pieces) {
      if (piece.getId().equalsIgnoreCase(id)) {
        return piece;
      }
    }

    return null;
  }

  @Override
  public void addPiece(ChessPiece piece) {
    if (hasPieceWithId(piece.getId())) {
      throw new IllegalStateException(piece.getId() + " already exist!");
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
    for (ChessPiece piece : pieces) {
      if (piece.getId().equalsIgnoreCase(id)) {
        return true;
      }
    }
    return false;
  }

  public ChessPiece[] getPieces() {
    return pieces;
  }
}
