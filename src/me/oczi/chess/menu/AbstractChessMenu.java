package me.oczi.chess.menu;

import java.util.Scanner;

/**
 * Abstract implementation of {@link ChessMenu}.
 */
public abstract class AbstractChessMenu implements ChessMenu {
  protected final Scanner scanner = new Scanner(System.in);

  @Override
  public void println(String string) {
    System.out.println(string);
  }

  @Override
  public void println(String... string) {
    for (String s : string) {
      println(s);
    }
  }

  @Override
  public String printLine(String string, Scanner scanner) {
    println(string);
    return scanner.nextLine();
  }

  @Override
  public char printLineChar(String string, Scanner scanner) {
    println(string);
    return scanner.next().charAt(0);
  }

  @Override
  public int printLineInt(String string, Scanner scanner) {
    println(string);
    return scanner.nextInt();
  }

  @Override
  public String printLine(Scanner scanner, String... string) {
    for (String s : string) {
      println(s);
    }
    return scanner.nextLine();
  }
}