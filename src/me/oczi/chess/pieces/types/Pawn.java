package me.oczi.chess.pieces.types;

import me.oczi.chess.location.ChessLocationImpl;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.AbstractChessPiece;
import me.oczi.chess.pieces.ChessMove;
import me.oczi.chess.pieces.ChessPieceType;

/**
 * A Pawn for the {@link ChessGame}.
 */
public class Pawn extends AbstractChessPiece {

  public Pawn(String id, int x, int y) {
    super(id,
        ChessPieceType.PAWN,
        ChessMove.MONO_SQUARE_STEP,
        new ChessLocationImpl(x, y));
  }

  public Pawn(int x, int y) {
    this(ChessPieceType.PAWN.getDefaultId(), x, y);
  }
}
