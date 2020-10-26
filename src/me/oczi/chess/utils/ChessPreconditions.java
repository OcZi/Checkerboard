package me.oczi.chess.utils;

import me.oczi.chess.object.exception.MoveOutOfBoundsException;

/**
 * Preconditions for chess related.
 */
public interface ChessPreconditions {

  /**
   * Check if id1 and id2 are the same.
   * @param id1 ID 1 to compare with ID 2.
   * @param id2 ID 2 to be compared.
   * @throws IllegalStateException if are the same.
   */
  static void checkId(String id1, String id2) {
    if (id1.equalsIgnoreCase(id2)) {
      throw new IllegalStateException(id1 + " already exist!");
    }
  }

  /**
   * Check if the number is outside of the chess table.
   * @param i Number to check
   * @param axis Axis name.
   * @throws MoveOutOfBoundsException If checks true.
   */
  static void checkMove(int i,
                        String axis) {
    if (i < 0) {
      throw new MoveOutOfBoundsException(
          String.format(
              "Movement of axis %s is equals or minor that 0!",
              axis));
    } else if (i > 8) {
      throw new MoveOutOfBoundsException(
          String.format(
              "Movement of axis %s is more that 16!",
              axis));
    }
  }

  /**
   * Check if string length is greater than length argument.
   * @param string String to get length.
   * @param length Length for check.
   * @throws IllegalArgumentException If checks true.
   */
  static void checkLength(String string, int length) {
    if (string.length() > length) {
      throw new IllegalArgumentException(
          "String '" + string + "' length are greater than " + length + "!");
    }
  }

  /**
   * Check if the two axis is outside of the Chess table.
   * @param x X axis.
   * @param y Y axis.
   * @throws IllegalStateException If checks true.
   */
  static void checkTableMove(int x, int y) {
    checkMove(x, "X");
    checkMove(y, "Y");
  }
}
