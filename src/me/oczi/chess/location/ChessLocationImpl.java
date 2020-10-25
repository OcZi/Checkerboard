package me.oczi.chess.location;

public class ChessLocationImpl implements ChessLocation {
  private final int x;
  private final int y;

  public ChessLocationImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return "ChessLocationImpl{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
