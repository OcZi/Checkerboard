package me.oczi.chess.pieces.moves;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

/**
 * Interface for apply movements to a piece in game.
 * Used in {@link ChessMove} and {@link ChessSpecialMove}.
 */
public interface TypeMove {

  /**
   * Get the possible moves in the adjacent locations.
   * @param game Chess Game to process Chess Table.
   * @param piece Piece to process movement.
   * @return An Array 2D of {@link ChessLocation}.
   */
  ChessLocation[][] getPossibleAdjacentMoves(ChessGame game,
                                             ChessPiece piece);
}
