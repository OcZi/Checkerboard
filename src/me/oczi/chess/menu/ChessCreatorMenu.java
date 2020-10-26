package me.oczi.chess.menu;

import me.oczi.chess.location.ChessLocationImpl;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.pieces.ChessPieceType;
import me.oczi.chess.pieces.types.Pawn;

/**
 * Chess Creator of Chess pieces Menu.
 */
public class ChessCreatorMenu extends AbstractChessMenu {
  private final ChessGame game;

  static void openCreatorMenu(ChessGame game) {
    new ChessCreatorMenu(game).openMenu();
  }

  ChessCreatorMenu(ChessGame game) {
    this.game = game;
  }

  @Override
  public void openMenu() {
    println("Select new chess:");
    for (ChessPieceType type : ChessPieceType.values()) {
      println("- " + type.name().toLowerCase());
    }
    ChessPiece piece;
    String next = scanner.nextLine();
    if (next == null || next.isEmpty()) {
      println("Invalid argument.");
      return;
    }
    // TODO: Change to switch after implement all the possibles chess pieces.
    switch (next.toLowerCase()) {
      case "pawn":
        piece = new Pawn();
        break;
      case "rook":
        piece = new Rook();
        break;
      case "queen":
        piece = new Queen();
        break;
      case "king":
        piece = new King();
        break;
      case "bishop":
        piece = new Bishop();
        break;
      case "knight":
        piece = new Knight();
        break;
      default:
        throw new IllegalArgumentException("Invalid chess.");
    }
    int x = printLineInt("Write the X axis:", scanner);
    int y = printLineInt("Write the Y axis:", scanner);
    piece.setCurrentLocation(
        // Minus X & Y for the array.
        new ChessLocationImpl(--x, --y));
    game.putPiece(x, y, piece);
  }
}
