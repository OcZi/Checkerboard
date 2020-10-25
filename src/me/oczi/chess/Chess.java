package me.oczi.chess;

import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.object.ChessGame;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.pieces.ChessPieceType;
import me.oczi.chess.pieces.types.Pawn;

import java.util.Scanner;

public class Chess {
  private static final Scanner input = new Scanner(System.in);

  /**
   * Basic method to initialize chess.
   * @param args Java args.
   */
  public static void main(String[] args) {
    menu();
  }

  public static void recursiveStart() {
    ChessGame chessGame = ChessGame.newBasicGame();
    while (true) {
      ChessTableGX.visualizeTable(chessGame);
      System.out.println("Execute a command:");
      System.out.println("Select <ID> - Select a piece by ID.");
      System.out.println("New - Create a new Chess piece.");
      String s = input.nextLine();
      System.out.println("s = " + s);
      if (s.equalsIgnoreCase("quit")) {
        break;
      }
      switchCommands(chessGame, s);
    }
  }

  public static void switchCommands(ChessGame game, String line) {
    if (line == null || line.isEmpty()) {
      System.out.println("Invalid command.");
      return;
    }
    System.out.println("line");
    String[] lines = line.split(" ");
    switch (lines[0].toLowerCase()) {
      case "select": ;
        ChessPiece piece = game.getPieceWithId(getArgOfLine(line));
        System.out.println("piece = " + piece);
        if (piece == null) break;
        select(game, piece);
        break;
      case "new":
        newChess(game);
        break;
      case "remove":

        break;
      default:
        System.out.println("Invalid command.");
        break;
    }
  }

  public static void newChess(ChessGame game) {
    System.out.println("Select new chess:");
    for (ChessPieceType type : ChessPieceType.values()) {
      System.out.println("- " + type.name().toLowerCase());
    }
    String next = input.nextLine();
    if (next == null || next.isEmpty()) {
      System.out.println("Invalid argument.");
      return;
    }
    System.out.println("Write the X axis:");
    int x = input.nextInt();
    System.out.println("Write the Y axis:");
    int y = input.nextInt();
    ChessPiece piece = null;
    if ("pawn".equals(next.toLowerCase())) {
      piece = new Pawn(x, y);
    } else {
      System.out.println("Invalid chess.");
    }
    if (piece == null) {
      return;
    }
    game.putPiece(x, y, piece);
  }

  private static String getArgOfLine(String line) {
    String[] s = line.split(" ");
    return s.length > 1 ? s[1] : "";
  }

  public static void select(ChessGame chessGame, ChessPiece piece) {
    ChessTableGX.visualizeMovement(chessGame, piece);
    System.out.println("Write the X axis:");
    int x = input.nextInt();
    System.out.println("Write the Y axis:");
    int y = input.nextInt();
    chessGame.removePiece(piece);
    chessGame.putPiece(x, y, piece);
  }

  public static void menu() {
    System.out.println("Checkerboard");
    System.out.println();
    System.out.println("v1.0");
    System.out.println("S - Start with a void Chess table.");
    System.out.println("Q - Quit");
    String line = input.nextLine();
    if (line.equalsIgnoreCase("s")) {
      recursiveStart();
    } else if (line.equalsIgnoreCase("q")) {
      return;
    } else {
      System.out.println("Invalid command.");
      menu();
    }
  }
}
