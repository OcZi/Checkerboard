package me.oczi.chess.pieces;

import me.oczi.chess.ChessPreconditions;
import me.oczi.chess.location.ChessLocation;

import static me.oczi.chess.ChessPreconditions.checkLength;

public abstract class AbstractChessPiece implements ChessPiece {
  protected String id;
  protected final ChessPieceType type;

  private ChessLocation[] possibleMoves;

  protected AbstractChessPiece(String id,
                               ChessPieceType type) {
    this.id = id;
    this.type = type;
  }

  @Override
  public void setId(String id) {
    checkLength(id, 2);
    this.id = id;
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
  public ChessLocation[] getPossibleMoves() {
    return possibleMoves;
  }
}