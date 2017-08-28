package com.umasuo.exception;

/**
 * Resource not exist.
 */
public class NotExistException extends RuntimeException {

  /**
   * default constructor.
   */
  public NotExistException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param msg String message
   */
  public NotExistException(String msg) {
    super(msg);
  }

}
