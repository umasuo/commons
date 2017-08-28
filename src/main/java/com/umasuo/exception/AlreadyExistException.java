package com.umasuo.exception;

/**
 * Resource already exist.
 */
public class AlreadyExistException extends RuntimeException {

  /**
   * default constructor.
   */
  public AlreadyExistException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param message String
   */
  public AlreadyExistException(String message) {
    super(message);
  }
}
