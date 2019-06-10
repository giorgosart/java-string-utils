/**
 *
 */
public class JavaTextUtils {

  private JavaTextUtils() { /* cannot be instantiated */ }

  /**
   * @param str the string to be examined
   * @param defaultString the default string to be used if the str is blank
   * @return the defaultString if the str is blank
   */
  public static String defaultString(String str, String defaultString) {
    return isBlank(str) ? defaultString : str;
  }

  /**
   * Checks if the string is null, its length is 0 or whitespace.
   *
   * @param str the string to be examined, can be null
   * @return true if str is null, its length is 0 or whitespace
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

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param width the expected width of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @return the original string if the length of the string is smaller than width
   */
  public static String truncate(String str, int width, TruncateAt trimPosition) {
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
  public static String truncate(String str, int width, TruncateAt trimPosition,
      boolean includeEllipsis) {
    if (isBlank(str) || str.length() < width) {
      return str;
    }
    if (trimPosition.equals(TruncateAt.START)) {
      return includeEllipsis ? str.substring(0, width) + "..." : str.substring(0, width);
    } else if (trimPosition.equals(TruncateAt.END)) {
      return includeEllipsis ? "..." + str.substring(width) : str.substring(width);
    }
    return str;
  }
}
