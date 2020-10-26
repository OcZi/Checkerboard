package me.oczi.chess.menu;

import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;

/**
 * Chess Command Menu.
 * Display all the available commands and manage the arguments
 * to the selected command.
 */
public class ChessCommandMenu extends AbstractChessMenu {
  private final ChessGame game;
  private final String[] args;

  public static void openCommandMenu(ChessGame game,
                                     String... args) {
    new ChessCommandMenu(game, args).openMenu();
  }

  ChessCommandMenu(ChessGame game,
                   String... args) {
    this.game = game;
    this.args = args;
  }

  @Override
  public void openMenu() {
    // Command line
    String line = args[0];
    if (line == null || line.isEmpty()) {
      println("Invalid argument.");
      return;
    }
    // TEST
    ChessPiece piece;
    switch (line.toLowerCase()) {
      case "select":
        ChessSelectMenu.openSelectMenu(
            game, getPieceArgChecked());
        break;
      case "new":
        ChessCreatorMenu.openCreatorMenu(game);
        break;
      case "remove":
        ChessRemoveMenu.openRemoveMenu(
            game, getPieceArgChecked());
        break;
      default:
        println("Invalid command.");
        break;
    }
  }

  private ChessPiece getPieceArgChecked() {
    // If args have a length of 1, doesn't have arguments.
    if (args.length < 2)  {
      throw new IllegalArgumentException("Invalid command.");
    }
    ChessPiece piece = game.getPieceWithId(
        String.valueOf(args[1]));
    if (piece == null) {
      throw new IllegalArgumentException("Invalid command.");
    }
    return piece;
  }
}
