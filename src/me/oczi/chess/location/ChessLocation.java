package me.oczi.chess.location;

public interface ChessLocation {

  /**
   * Get X axis of Location.
   * @return X axis of location.
   */
  int getX();

  /**
   * Get Y axis of Location.
   * @return Y axis of location.
   */
  int getY();

  /**
   * Get X axis of Chess Location with checks.
   * @return X axis, or -1 if checks fail.
   */
  default int getXChecked() {
    int x = getX();
    // Check if is inside of Chess table.
    return x >= 8 || x < 0 ? -1 : x;
  }

  /**
   * Get Y axis of Chess Location with checks.
   * @return X axis, or -1 if checks fail.
   */
  default int getYChecked() {
    int y = getY();
    // Check if is inside of Chess table.
    return y >= 8 || y < 0 ? -1 : y;
  }
}
