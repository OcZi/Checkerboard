package me.oczi.chess.pieces.moves;

import me.oczi.chess.location.ChessDirection;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

import static me.oczi.chess.location.ChessDirection.*;

public enum ChessMove implements TypeMove {
  SQUARE_STEP(SOUTH, EAST, NORTH, WEST), // King
  MONO_SQUARE_STEP(NORTH), // Pawn
  DIAGONAL_STEP(NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST), // Queen
  ANY_STEP(SQUARE_STEP, DIAGONAL_STEP);// Queen

  private final ChessDirection[] directions;

  ChessMove(ChessDirection... directions) {
    this.directions = directions;
  }

  ChessMove(ChessMove... moves) {
    int totalLength = 0;
    // First iteration to get the total length of all arrays.
    for (ChessMove move : moves) {
      totalLength += move.directions.length;
    }
    ChessDirection[] directions = new ChessDirection[totalLength];
    int slot = 0;
    for (ChessMove move : moves) {
      for (ChessDirection direction : move.directions) {
        directions[slot] = direction;
        ++slot;
      }
    }
    this.directions = directions;
  }

  @Override
  public ChessLocation[][] getPossibleAdjacentMoves(ChessGame game,
                                                    ChessPiece piece) {
    ChessLocation currentLocation = piece.getCurrentLocation();
    ChessLocation[][] locations = new ChessLocation[8][8];
    for (ChessDirection direction : directions) {
      ChessLocation lastLocation = currentLocation;
      while (true) {
        lastLocation =
            direction.applyTo(lastLocation);
        // Limit Chess table checks
        int x = lastLocation.getXChecked();
        if (x == -1) break;
        int y = lastLocation.getYChecked();
        if (y == -1) break;
        // If found a piece in the direction, break iteration.
        ChessPiece pieceAt = game.getPieceAt(x, y);
        if (pieceAt != null) break;
        // If not have freedom move, break after first iteration.
        locations[x][y] = lastLocation;
        if (!piece.hasFreedomMove()) {
          break;
        }
      }
    }
    return locations;
  }
}
