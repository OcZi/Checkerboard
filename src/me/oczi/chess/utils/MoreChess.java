package me.oczi.chess.utils;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.pieces.ChessPiece;

public interface MoreChess {

  static boolean chessEquals(ChessPiece piece, int x, int y) {
    ChessLocation currentLocation = piece.getCurrentLocation();
    return
        currentLocation.getX() == x &&
        currentLocation.getY() == y;
  }
}
