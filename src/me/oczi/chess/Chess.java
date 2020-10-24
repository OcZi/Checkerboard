package me.oczi.chess;

import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.object.ChessTable;
import me.oczi.chess.pieces.types.Pawn;

public class Chess {

  /**
   * Basic method to initialize chess.
   * @param args Java args.
   */
  public static void main(String[] args) {
    ChessTable chessTable = ChessTable.newBasicTable();
    // Normal creation of piece
    chessTable.newPiece(4, 4, new Pawn());
    ChessTableGX.visualizeTable(chessTable);

    // Incorrect creation of piece
    // Will throw MoveOutOfBoundsException
    Pawn pawn = new Pawn();
    pawn.setId("P22");
    chessTable.newPiece(8, 4, pawn);
    ChessTableGX.visualizeTable(chessTable);
  }
}
