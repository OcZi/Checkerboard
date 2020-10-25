package me.oczi.chess.location;

import me.oczi.chess.pieces.ChessPiece;

/**
 * Directions that can use a {@link ChessPiece}.
 */
public enum ChessDirection {
  SOUTH(0, -1),
  NORTH(0, 1),
  EAST(-1, 0),
  WEST(1, 0),

  // Diagonal directions
  SOUTHEAST(SOUTH, EAST),
  SOUTHWEST(SOUTH, EAST),
  NORTHEAST(NORTH, WEST),
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

  public ChessLocation applyTo(ChessLocation chessLocation) {
    return new ChessLocationImpl(
        chessLocation.getX() + x,
        chessLocation.getY() + y);
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
