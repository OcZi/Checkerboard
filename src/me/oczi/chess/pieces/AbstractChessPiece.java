package me.oczi.chess.pieces;

import me.oczi.chess.location.ChessLocation;
import me.oczi.chess.object.ChessGame;

import static me.oczi.chess.ChessPreconditions.checkLength;

public abstract class AbstractChessPiece implements ChessPiece {
  protected String id;
  protected final ChessPieceType type;
  protected final ChessMove move;

  protected ChessLocation currentLocation;

  protected AbstractChessPiece(String id,
                               ChessPieceType type,
                               ChessMove move,
                               ChessLocation currentLocation) {
    this.id = id;
    this.type = type;
    this.move = move;
    this.currentLocation = currentLocation;
  }

  @Override
  public void setId(String id) {
    checkLength(id, 2);
    this.id = id;
  }

  @Override
  public void setCurrentLocation(ChessLocation location) {
    this.currentLocation = location;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public ChessPieceType getType() {
    return type;
  }

  @Override
  public ChessLocation getCurrentLocation() {
    return currentLocation;
  }

  @Override
  public ChessLocation[][] getPossibleMoves(ChessGame game) {
    return move.getPossibleAdjacentMoves(game, this);
  }
}