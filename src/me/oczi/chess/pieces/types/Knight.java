package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessSpecialMove;

public class Knight extends AbstractChessPiece {

  public Knight() {
    super(ChessPieceType.KNIGHT, ChessSpecialMove.L_SHAPE_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return false;
  }
}
