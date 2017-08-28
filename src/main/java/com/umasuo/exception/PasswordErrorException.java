package com.umasuo.exception;

/**
 * Password or username not correct.
 */
public class PasswordErrorException extends RuntimeException {
  /**
   * default constructor.
   */
  public PasswordErrorException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param message String
   */
  public PasswordErrorException(String message) {
    super(message);
  }
}
