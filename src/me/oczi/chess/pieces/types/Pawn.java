package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.ChessPieceType;

public class Pawn extends AbstractChessPiece {

  public Pawn(String id) {
    super(id, ChessPieceType.PAWN);
  }

  public Pawn() {
    this(ChessPieceType.PAWN.getDefaultId());
  }
}
