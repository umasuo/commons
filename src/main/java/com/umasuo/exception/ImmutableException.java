package com.umasuo.exception;

/**
 * Resource can not be changed.
 */
public class ImmutableException extends RuntimeException {

  /**
   * Instantiates a new Immutable exception.
   */
  public ImmutableException() {
    super();
  }

  /**
   * Instantiates a new Immutable exception.
   *
   * @param message the message
   */
  public ImmutableException(String message) {
    super(message);
  }
}
