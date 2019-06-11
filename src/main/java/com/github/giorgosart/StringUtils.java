package com.github.giorgosart;

/**
 * All String operations are null safe
 *
 * @author George.Artemiou
 * @version 1.0.0
 * @since 1.0.0
 */
public class StringUtils {

  private StringUtils() { /* cannot be instantiated */ }

  /**
   * returns the default string passed in if the string to be examined is blank
   *
   * @param str the string to be examined
   * @param defaultString the default string to be used if the str is blank
   * @return the defaultString if the str is blank
   */
  public static String defaultString(String str, String defaultString) {
    return Validator.isBlank(str) ? defaultString : str;
  }

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param width the expected width of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @return the original string if the length of the string is smaller than width
   */
  public static String truncate(String str, int width, String trimPosition) {
    return truncate(str, width, trimPosition, false);
  }

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param width the expected width of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @param includeEllipsis whether the ellipsis characters should be included
   * @return the original string if the length of the string is smaller than width, otherwise the
   * truncated string
   */
  public static String truncate(String str, int width, String trimPosition,
      boolean includeEllipsis) {
    if (Validator.isBlank(str) || str.length() < width) {
      return str;
    }
    if (trimPosition.equals(TruncateAt.START.toString())) {
      return includeEllipsis ? str.substring(0, width) + "..." : str.substring(0, width);
    } else if (trimPosition.equals(TruncateAt.END.toString())) {
      return includeEllipsis ? "..." + str.substring(width) : str.substring(width);
    }
    return str;
  }
}
