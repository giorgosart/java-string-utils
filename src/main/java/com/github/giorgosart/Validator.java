package com.github.giorgosart;

/**
 * A class used for String validation
 *
 * All String operations are null safe
 *
 * @author George.Artemiou
 * @version 1.0.0
 * @since 1.0.0
 */
public class Validator {

  /**
   * Checks if the string is null, its length is 0 or a whitespace.
   *
   * @param str the string to be examined, can be null
   * @return true if str is null, its length is 0 or a whitespace
   */
  public static boolean isBlank(String str) {
    return (str == null || str.isEmpty() || str.matches("^\\s*$"));
  }

  /**
   * Checks if the string is null or its length is 0.
   *
   * @param str the string to be examined, can be null
   * @return true if str is null or its length is 0
   */
  public static boolean isEmpty(String str) {
    return (str == null || str.isEmpty());
  }

}
