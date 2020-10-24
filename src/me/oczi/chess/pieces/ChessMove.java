package me.oczi.chess.pieces;

public enum ChessMove {
  SQUARE_STEP(false),
  DIAGONAL_STEP(false),
  ;

  private final boolean freedomMove;

  ChessMove(boolean freedomMove) {
    this.freedomMove = freedomMove;
  }

  public boolean hasFreedomMove() {
    return freedomMove;
  }
}
