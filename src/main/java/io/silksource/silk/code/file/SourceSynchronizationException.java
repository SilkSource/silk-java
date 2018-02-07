package io.silksource.silk.code.file;


/**
 * Something went wrong when synchronizing in-memory source with the file system.
 */
public class SourceSynchronizationException extends RuntimeException {

  private static final long serialVersionUID = 7127270476564755516L;

  public SourceSynchronizationException(String message, Throwable cause) {
    super(message, cause);
  }

}
