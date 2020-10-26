package me.oczi.chess.pieces.types;

import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.moves.ChessMove;

/**
 * A Pawn for the {@link ChessGame}.
 */
public class Pawn extends AbstractChessPiece {

  public Pawn() {
    super(ChessPieceType.PAWN,
        ChessMove.MONO_SQUARE_STEP);
  }

  @Override
  public boolean hasFreedomMove() {
    return false;
  }
}
