package me.oczi.chess.pieces;

public enum ChessPieceType {
  PAWN,
  BISHOP,
  KNIGHT,
  TOWER,
  QUEEN,
  KING;

  public String getDefaultId() {
    return String.valueOf(toString().charAt(0));
  }
}
