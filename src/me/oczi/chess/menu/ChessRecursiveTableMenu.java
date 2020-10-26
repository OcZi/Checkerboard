package me.oczi.chess.menu;

import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.object.ChessGame;

/**
 * Chess Table menu.
 * Works recursively except if the line input is "Quit".
 */
public class ChessRecursiveTableMenu extends AbstractChessMenu {

  @Override
  public void openMenu() {
    ChessGame chessGame = ChessGame.newBasicGame();
    while (true) {
      ChessTableGX.visualizeTable(chessGame);
      println(
          "Execute a command:",
          "Select <ID> - Select a piece to move by ID.",
          "Remove <ID> - Remove a Chess piece.",
          "New - Create a new Chess piece.",
          "Quit - Quit menu.");
      String line = scanner.nextLine();
      if (line.equalsIgnoreCase("quit")) {
        break;
      }
      try {
        ChessCommandMenu.openCommandMenu(
            chessGame,
            // Split all spaces in line to get arguments.
            line.split(" "));
        // Bad catch.
        // Any exception can throws in this process.
      } catch (Exception e) {
        println(
            String.format("Error %s: %s",
                e.getClass().getSimpleName(),
                e.getMessage()));
      }
    }
  }
}
