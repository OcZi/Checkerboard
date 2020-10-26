package me.oczi.chess.menu;

import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.utils.ChessPreconditions;
import me.oczi.chess.utils.MoreChess;

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
    // Basic check of axis
    int x = printLineInt(
        "Write the X axis number:", scanner);
    char yChar = printLineChar(
        "Write the Y axis letter:", scanner);
    int y = MoreChess.indexOfAlphabetic(yChar);
    if (y == -1) {
      throw new IllegalArgumentException(
          "Invalid letter for Y axis: " + yChar);
    }
    ChessPreconditions.checkTableMove(x, y);
    // Primitive minus for array slots.
    --x;
    --y;
    ChessLocation nextLocation = possibleMoves[x][y];
    if (nextLocation == null) {
      throw new IllegalArgumentException("Impossible move");
    }
    game.swapPiece(x, y, piece);
  }
}
