package me.oczi.chess.console;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.utils.MoreChess;

public interface ChessTableGX {

  /**
   * Visualize the table in the CLI.
   * @param table ChessTable to visualize.
   */
  static void visualizeTable(ChessGame table) {
    ChessPiece[][] arrayTable = table.getArrayTable();
    String[] rows = new String[9];
    rows[0] = generateHorizontalNumbers(arrayTable.length);
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
      rows[i+1] = builder.toString();
    }
    for (String row : rows) {
      System.out.println(row);
    }
    System.out.println();
  }

  /**
   * Visualize the Chess table only
   * with the piece and their possible moves.
   * @param possibleMoves Possible moves.
   * @param piece Piece to visualize.
   */
  static void visualizeMovement(ChessLocation[][] possibleMoves,
                                ChessPiece piece) {
    String[] rows = new String[9];
    // Some of the logic is the same as visualizeTable
    // but iterating possibleMoves.
    rows[0] = generateHorizontalNumbers(possibleMoves.length);
    for (int x = 0; x < possibleMoves.length; x++) {
      StringBuilder builder = new StringBuilder(x + 1 + " ");
      ChessLocation[] yMove = possibleMoves[x];
      int lastLength = 2;
      for (int y = 0; y < yMove.length; y++) {
        ChessLocation chessLocation = yMove[y];
        if (builder.length() > 0) {
          builder.append(lastLength == 2 ? " " : "  ");
        }
        if (chessLocation == null) {
          // Check if location is the piece of the method's parameter.
          String symbol = MoreChess.chessEquals(piece, x, y)
              ? piece.getId()
              : ".";
          builder.append(symbol);
          lastLength = Math.min(symbol.length(), 2);
        } else {
          builder.append("*");
          lastLength = 1;
        }
      }
      rows[x+1] = builder.toString();
    }
    for (String row : rows) {
      System.out.println(row);
    }
    System.out.println();
  }

  /**
   * Generate a horizontal count of numbers
   * for the Chess table.
   * @param count Count of numbers.
   * @return Horizontal count of numbers as String.
   */
  static String generateHorizontalNumbers(int count) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < count; i++) {
      // Extra space in the first iteration.
      if (builder.length() == 0) {
        builder.append(" ");
      }
      builder.append("  ").append(i + 1);
    }
    return builder.toString();
  }
}
