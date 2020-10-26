package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessMove;

public class King extends AbstractChessPiece {

  public King() {
    super(ChessPieceType.KING, ChessMove.ANY_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return false;
  }
}
