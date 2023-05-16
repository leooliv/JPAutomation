package com.jpmorgan.core;

/**
 * Exceptions
 */
public class WebDriverException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public WebDriverException() {
    super();
  }

  public WebDriverException(String message, Throwable cause) {
    super(message, cause);
  }

  public WebDriverException(String message) {
    super(message);
  }

  public WebDriverException(Throwable cause) {
    super(cause);
  }
}
