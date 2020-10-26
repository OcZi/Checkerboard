package me.oczi.chess.utils;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.location.ChessLocationImpl;
import me.oczi.chess.pieces.ChessPiece;

public interface MoreChess {
  // Exposed alphabetic char array.
  char[] alphabetic = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};


  static boolean chessEquals(ChessPiece piece,
                             int x,
                             int y) {
    ChessLocation currentLocation = piece.getCurrentLocation();
    return
        currentLocation.getX() == x &&
        currentLocation.getY() == y;
  }

  static ChessLocation addLocation(ChessLocation location,
                                   int x,
                                   int y) {
    return new ChessLocationImpl(
        location.getX() + x,
        location.getY() + y);
  }

  /**
   * Get index of character in Alphabetic array.
   * @param c Char to check.
   * @return Index of character, or -1 if not found.
   */
  static int indexOfAlphabetic(char c) {
    c = Character.toUpperCase(c);
    if (!Character.isAlphabetic(c)) {
      return -1;
    }
    for (int i = 0; i < alphabetic.length; i++) {
      char alpha = alphabetic[i];
      if (c == alpha) {
        return i + 1; // +1 for real location in array
      }
    }
    return -1;
  }
}
