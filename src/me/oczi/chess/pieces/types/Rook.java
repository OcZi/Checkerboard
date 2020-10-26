package me.oczi.chess.pieces.types;

import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessMove;

public class Rook extends AbstractChessPiece {

  public Rook() {
    super(ChessPieceType.ROOK,
        ChessMove.SQUARE_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return true;
  }
}
