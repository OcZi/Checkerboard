package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessMove;

public class Bishop extends AbstractChessPiece {

  public Bishop() {
    super(ChessPieceType.BISHOP, ChessMove.DIAGONAL_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return true;
  }
}
