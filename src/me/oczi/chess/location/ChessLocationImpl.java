package me.oczi.chess.location;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChessLocationImpl that = (ChessLocationImpl) o;
    return x == that.x &&
        y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
