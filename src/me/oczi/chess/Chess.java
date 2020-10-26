package me.oczi.chess;

import me.oczi.chess.menu.ChessMainMenu;

public class Chess {

  /**
   * Basic method to initialize chess.
   * @param args Java args.
   */
  public static void main(String[] args) {
    // Don't assign this object to a variable.
    // will need to be deleted by the garbage collector.

    // (but anyway, after this line of code
    // the program will just quit)
    new ChessMainMenu().openMenu();
  }
}
