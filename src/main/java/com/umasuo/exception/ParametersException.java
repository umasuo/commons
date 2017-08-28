package com.umasuo.exception;

/**
 * Parameters not correct.
 */
public class ParametersException extends RuntimeException {

  /**
   * default constructor.
   */
  public ParametersException() {
    super();
  }

  /**
   * constructor with message.
   *
   * @param message String
   */
  public ParametersException(String message) {
    super(message);
  }

}
