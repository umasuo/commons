package com.umasuo.exception;

/**
 * Create new resource failed.
 */
public class CreateResourceFailed extends RuntimeException {

  /**
   * default constructor.
   */
  public CreateResourceFailed() {
    super();
  }

  /**
   * construtor with message.
   *
   * @param msg
   */
  public CreateResourceFailed(String msg) {
    super(msg);
  }
}
