package me.oczi.chess.menu;

public class ChessMainMenu extends AbstractChessMenu {

  @Override
  public void openMenu() {
    println("Checkerboard",
        "",
        "v1.1",
        "S - Start with a void Chess table.",
        "Q - Quit");
    String line = scanner.nextLine();
    if (line.equalsIgnoreCase("s")) {
      // No assign this object to a variable.
      // This object will be always temporal.
      new ChessRecursiveTableMenu().openMenu();
    } else if (line.equalsIgnoreCase("q")) {
      return;
    }
    openMenu();
  }
}
