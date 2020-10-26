package me.oczi.chess.menu;

public class ChessMainMenu extends AbstractChessMenu {

  @Override
  public void openMenu() {
    println("[Checkerboard v1.2]",
        "Chess table simulator.",
        "Designed for debugging.",
        "",
        "S - Start new game.",
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
