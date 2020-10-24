package me.oczi.chess.object.exception;

public class MoveOutOfBoundsException extends RuntimeException {

  public MoveOutOfBoundsException(String errMessage, Throwable t) {
    super(errMessage, t);
  }

  public MoveOutOfBoundsException(String errMessage) {
    super(errMessage);
  }

  public MoveOutOfBoundsException(Throwable t) {
    super(t);
  }
}