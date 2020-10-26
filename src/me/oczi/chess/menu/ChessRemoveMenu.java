package me.oczi.chess.menu;

import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

public class ChessRemoveMenu extends AbstractChessMenu {
  private final ChessGame game;
  private final ChessPiece piece;

  public static void openRemoveMenu(ChessGame game, ChessPiece piece) {
    new ChessRemoveMenu(game, piece).openMenu();
  }

  ChessRemoveMenu(ChessGame game, ChessPiece piece) {
    this.game = game;
    this.piece = piece;
  }


  @Override
  public void openMenu() {
    // Yes, just a one line of code.
    game.removePiece(piece);
  }
}
