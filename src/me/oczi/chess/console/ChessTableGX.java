package me.oczi.chess.console;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

public interface ChessTableGX {

  /**
   * Visualize the table in the CLI.
   * @param table ChessTable to visualize.
   */
  static String[] visualizeTable(ChessGame table) {
    ChessPiece[][] arrayTable = table.getArrayTable();
    String[] rows = new String[8];
    for (int i = 0; i < arrayTable.length; i++) {
      ChessPiece[] xRow = arrayTable[i];
      StringBuilder builder = new StringBuilder(i + 1 + " ");
      int lastLength = 2;
      for (ChessPiece yPiece : xRow) {
        // if not the first yPiece in xRow, separate them with
        // the last length of id registered.
        if (builder.length() > 0) {
          builder.append(lastLength == 2 ? " " : "  ");
        }
        // If location has a piece, print their symbol in the table.
        // else just print a dot.
        String id = yPiece == null
            ? "."
            : yPiece.getId();
        // If length of is greater than 2, will ignore them and assign to 2.
        // This will never happen, because will throw a exception
        // in ChessPiece#setId() before.
        lastLength = Math.min(id.length(), 2);
        builder.append(id);
      }
      rows[i] = builder.toString();
    }
    for (String row : rows) {
      System.out.println(row);
    }
    System.out.println();
    return rows;
  }

  static void visualizeMovement(ChessGame chessGame, ChessPiece piece) {
    ChessPiece[][] arrayTable = chessGame.getArrayTable();
    ChessLocation[][] possibleMoves = piece.getPossibleMoves(chessGame);
    String[] rows = new String[8];
    for (int i = 0; i < arrayTable.length; i++) {
      ChessPiece[] xRow = arrayTable[i];
      StringBuilder builder = new StringBuilder(i + 1 + " ");
      boolean isMove = false;
      for (ChessPiece yPiece : xRow) {
        if (builder.length() > 0) {
          builder.append("  ");
        }
        if (yPiece == null) {
          builder.append(".");
          continue;
        }
        int y = yPiece.getCurrentLocation().getY();
        int x = yPiece.getCurrentLocation().getX();
        for (int i1 = 0; i1 < possibleMoves.length; i1++) {
          if (i1 != x) {
            continue;
          }
          for (int i2 = 0; i2 < possibleMoves[x].length; i2++) {
            if (i2 != y) {
              continue;
            }

            isMove = true;
          }
        }
        builder.append(isMove ? "0" : ".");
      }
      rows[i] = builder.toString();
    }
    for (String row : rows) {
      System.out.println(row);
    }
    System.out.println();
  }
}
