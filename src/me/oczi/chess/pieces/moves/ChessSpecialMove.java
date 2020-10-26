package me.oczi.chess.pieces.moves;

import me.oczi.chess.location.ChessDirection;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.utils.MoreChess;

import static me.oczi.chess.location.ChessDirection.*;

/**
 * Implementation of {@link TypeMove} for special cases
 * like Knight move.
 */
public enum ChessSpecialMove implements TypeMove {
  L_SHAPE_STEP(SOUTH, EAST, NORTH, WEST); // Knight move

  private final ChessDirection[] directions;

  ChessSpecialMove(ChessDirection... directions) {
    this.directions = directions;
  }

  @Override
  public ChessLocation[][] getPossibleAdjacentMoves(ChessGame game, ChessPiece piece) {
    ChessLocation currentLocation = piece.getCurrentLocation();
    ChessLocation[][] possibleMoves = new ChessLocation[8][8];
    for (ChessDirection direction : directions) {
      int xMultiplier = direction.getX() * 2;
      int yMultiplier = direction.getY() * 2;
      ChessLocation bifurcation = MoreChess.addLocation(
          currentLocation, xMultiplier, yMultiplier);
      ChessLocation[] biMove = switchBifurcation(
          bifurcation, direction);
      for (ChessLocation chessLocation : biMove) {
        // Limit Chess table checks
        int x = chessLocation.getXChecked();
        if (x == -1) break;
        int y = chessLocation.getYChecked();
        if (y == -1) break;
        // Present piece in location check
        ChessPiece pieceAt = game.getPieceAt(x, y);
        if (pieceAt != null) continue;
        possibleMoves[x][y] = chessLocation;
      }
    }
    return possibleMoves;
  }

  private ChessLocation[] switchBifurcation(ChessLocation bifurcation,
                                            ChessDirection direction) {
    ChessLocation[] biMove = new ChessLocation[2];
    switch (direction) {
      case NORTH:
      case SOUTH:
        biMove[0] = WEST.applyTo(bifurcation);
        biMove[1] = EAST.applyTo(bifurcation);
        break;
      case EAST:
      case WEST:
      default:
        biMove[0] = NORTH.applyTo(bifurcation);
        biMove[1] = SOUTH.applyTo(bifurcation);
        break;
    }
    return biMove;
  }
}
