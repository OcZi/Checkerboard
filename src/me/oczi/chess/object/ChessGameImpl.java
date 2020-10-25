package me.oczi.chess.object;

import me.oczi.chess.ChessPreconditions;
import me.oczi.chess.console.ChessTableGX;
import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.pieces.ChessPiece;
import me.oczi.chess.team.ChessTeam;

/**
 * Basic implementation of {@link ChessGame}.
 */
public class ChessGameImpl implements ChessGame {
  // Array 2D as table.
  private final ChessPiece[][] arrayTable;

  // For now, will be only an one team.
  private final ChessTeam team;

  ChessGameImpl() {
    // 8x8 dimensions.
    this(new ChessPiece[8][8]);
  }

  ChessGameImpl(ChessPiece[][] arrayTable) {
    this.arrayTable = arrayTable;
    this.team = ChessTeam.newTeam();
  }

  @Override
  public ChessPiece getPieceAt(int x, int y) {
    // Yep, just a array accessor.
    return arrayTable[x][y];
  }

  @Override
  public ChessPiece getPieceWithId(String id) {
    return team.getPiece(id);
  }

  @Override
  public void putPiece(int x, int y, ChessPiece piece) {
    // If table axis move of piece are greater than 8
    // or minor than 0, will throw a exception.
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[--x][--y] = piece;
    team.addPiece(piece);
  }

  @Override
  public void removePiece(ChessPiece piece) {
    // The same that putPiece()
    ChessLocation currentLocation = piece.getCurrentLocation();
    int x = currentLocation.getX();
    int y = currentLocation.getY();
    ChessPreconditions.checkTableMove(x, y);
    arrayTable[--x][--y] = null;
    team.removePiece(piece);
  }

  @Override
  public ChessPiece[][] getArrayTable() {
    return arrayTable;
  }

  @Override
  public ChessTeam getTeam() {
    return team;
  }
}
