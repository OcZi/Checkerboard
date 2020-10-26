package me.oczi.chess.location;

import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.utils.MoreChess;

/**
 * Directions that can use a {@link ChessPiece}.
 */
public enum ChessDirection {
  NORTH(-1, 0),
  SOUTH(1, 0),
  EAST(0, 1),
  WEST(0, -1),

  // Diagonal directions
  SOUTHEAST(SOUTH, EAST),
  SOUTHWEST(SOUTH, WEST),
  NORTHEAST(NORTH, EAST),
  NORTHWEST(NORTH, WEST);

  private final int x;
  private final int y;

  ChessDirection(int x, int y) {
    this.x = x;
    this.y = y;
  }

  ChessDirection(ChessDirection... directions) {
    int x = 0;
    int y = 0;
    for (ChessDirection direction : directions) {
      x += direction.getX();
      y += direction.getY();
    }
    this.x = x;
    this.y = y;
  }

  /**
   * Apply X & Y axis to the Chess Location.
   * @param chessLocation Chess location to apply.
   * @return Applied Chess Location.
   */
  public ChessLocation applyTo(ChessLocation chessLocation) {
    return MoreChess.addLocation(chessLocation, x, y);
  }

  /**
   * Get Y axis of direction.
   * @return Y axis.
   */
  public int getY() {
    return y;
  }

  /**
   * Get X axis of direction.
   * @return X axis.
   */
  public int getX() {
    return x;
  }
}
