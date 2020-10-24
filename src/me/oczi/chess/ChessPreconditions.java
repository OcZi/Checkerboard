package me.oczi.chess;

import me.oczi.chess.object.exception.MoveOutOfBoundsException;

public interface ChessPreconditions {

  static void checkMove(int i,
                        String axis) {
    if (i <= 0) {
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

  static void checkLength(String string, int length) {
    if (string.length() > length) {
      throw new IllegalArgumentException(
          "String '" + string + "' length are greater than " + length + "!");
    }
  }

  static void checkTableMove(int x, int y) {
    checkMove(x, "X");
    checkMove(y, "Y");
  }
}
