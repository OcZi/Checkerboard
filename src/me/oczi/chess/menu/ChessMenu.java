package me.oczi.chess.menu;

import me.oczi.chess.object.ChessGame;

import java.util.Scanner;

/**
 * Chess menu for the {@link ChessGame}.
 */
public interface ChessMenu {

  /**
   * Open menu.
   */
  void openMenu();

  /**
   * Print a string in a new line.
   * @param string String to print.
   */
  void println(String string);

  /**
   * Print strings in different lines.
   * @param string Strings to print.
   */
  void println(String... string);

  /**
   * Print a string in a new line and await {@link Scanner#nextLine()}.
   * @param string String to print.
   * @param scanner Scanner for internal use.
   * @return Line input of the console.
   */
  String printLine(String string, Scanner scanner);

  /**
   * Print a string in a new line and await {@link Scanner#nextInt()}
   * @param string String to print.
   * @param scanner Scanner for internal use.
   * @return Line input of the console.
   */
  int printLineInt(String string, Scanner scanner);

  /**
   * Print strings in different lines and await {@link Scanner#nextLine()}.
   * @param string Strings to print.
   * @param scanner Scanner for internal use.
   * @return Line input of the console.
   */
  String printLine(Scanner scanner, String... string);
}
