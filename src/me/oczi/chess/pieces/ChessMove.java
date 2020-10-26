package me.oczi.chess.pieces;

import me.oczi.chess.location.ChessDirection;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;

import static me.oczi.chess.location.ChessDirection.*;

public enum ChessMove {
  SQUARE_STEP(false, SOUTH, EAST, NORTH, WEST),
  DUO_SQUARE_STEP(false, SOUTH, NORTH), // Fpr Pawn
  DIAGONAL_STEP(false, NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST),
  ;

  private final boolean freedomMove;
  private final ChessDirection[] directions;

  ChessMove(boolean freedomMove, ChessDirection... directions) {
    this.freedomMove = freedomMove;
    this.directions = directions;
  }

  /**
   * Check if can move infinitely.
   * @return Has freedom move.
   */
  public boolean hasFreedomMove() {
    return freedomMove;
  }

  /**
   * Get the possible moves in the adjacent locations.
   * @param game Chess Game to process Chess Table.
   * @param piece Piece to process movement.
   * @return An Array 2D of {@link ChessLocation}.
   */
  public ChessLocation[][] getPossibleAdjacentMoves(ChessGame game,
                                                    ChessPiece piece) {
    ChessLocation currentLocation = piece.getCurrentLocation();
    ChessLocation[][] locations = new ChessLocation[8][8];
    for (ChessDirection direction : directions) {
      while (true) {
        ChessLocation chessLocation =
            direction.applyTo(currentLocation);
        // Limit Chess table checks
        int x = chessLocation.getX();
        if (x > 8 || x < 0) {
          break;
        }
        int y = chessLocation.getY();
        if (y > 8 || y < 0) {
          break;
        }
        // If found a piece in the direction, break iteration.
        ChessPiece pieceAt = game.getPieceAt(x, y);
        if (pieceAt != null) {
          break;
        }
        // If not have freedom move, break after first iteration.
        locations[x][y] = chessLocation;
        if (!freedomMove) {
          break;
        }
      }
    }
    return locations;
  }
}
