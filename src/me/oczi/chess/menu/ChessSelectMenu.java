package me.oczi.chess.menu;

import me.oczi.chess.ChessPreconditions;
import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

public class ChessSelectMenu extends AbstractChessMenu {
  private final ChessGame game;
  private final ChessPiece piece;

  static void openSelectMenu(ChessGame game, ChessPiece piece) {
    new ChessSelectMenu(game, piece).openMenu();
  }

  ChessSelectMenu(ChessGame game, ChessPiece piece) {
    this.game = game;
    this.piece = piece;
  }

  @Override
  public void openMenu() {
    ChessLocation[][] possibleMoves = piece.getPossibleMoves(game);
    ChessTableGX.visualizeMovement(possibleMoves, piece);
    int x = printLineInt(
        "Write the X axis:", scanner);
    int y = printLineInt(
        "Write the Y axis:", scanner);
    ChessPreconditions.checkTableMove(x, y);
    // Primitive minus
    --x;
    --y;
    ChessLocation nextLocation = possibleMoves[x][y];
    if (nextLocation == null) {
      throw new IllegalArgumentException("Impossible move");
    }
    game.swapPiece(x, y, piece);
  }
}
