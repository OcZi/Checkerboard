package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessMove;

public class Queen extends AbstractChessPiece {

  public Queen() {
    super(ChessPieceType.QUEEN, ChessMove.ANY_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return true;
  }
}
