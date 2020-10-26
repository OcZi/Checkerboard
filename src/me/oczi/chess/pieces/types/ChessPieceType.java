package me.oczi.chess.pieces.types;

/**
 * All the available Chess pieces.
 */
public enum ChessPieceType {
  PAWN,
  BISHOP,
  KNIGHT {
    // Dirty override ID.
    // Fix the problem of Knight-King same id.
    @Override
    public String getDefaultId() {
      return "N";
    }
  },
  ROOK,
  QUEEN,
  KING;

  /**
   * Get default ID of Chess piece.
   * @return First character of Chess piece.
   */
  public String getDefaultId() {
    return String.valueOf(toString().charAt(0));
  }
}
