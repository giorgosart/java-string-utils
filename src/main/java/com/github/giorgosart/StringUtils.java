package com.github.giorgosart;

import java.util.Arrays;

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
   * Checks if two words are an anagram of each other
   *
   * @param firstWord the first word to be examined
   * @param secondWord the second word to be examined
   * @return true or false based weather the two words are an anagram of each other
   * @since 1.1.0
   */
  public static boolean areAnagram(String firstWord, String secondWord) {
    if (isEmpty(firstWord) || isEmpty(secondWord)) {
      return false;
    }
    return Arrays.equals(firstWord.replaceAll(" ", "").codePoints().sorted().toArray(),
        secondWord.replaceAll(" ", "").codePoints().sorted().toArray());
  }

  /**
   * returns the default string passed in if the string to be examined is blank
   *
   * @param str the string to be examined
   * @param defaultString the default string to be used if the str is blank
   * @return the defaultString if the str is blank
   * @since 1.0.0
   */
  public static String defaultString(String str, String defaultString) {
    return isBlank(str) ? defaultString : str;
  }

  /**
   * Checks if the string is null, its length is 0 or a whitespace.
   *
   * @param str the string to be examined, can be null
   * @return true if str is null, its length is 0 or a whitespace
   * @since 1.0.0
   */
  public static boolean isBlank(String str) {
    return (str == null || str.isEmpty() || str.matches("^\\s*$"));
  }

  /**
   * Checks if the string is null or its length is 0.
   *
   * @param str the string to be examined, can be null
   * @return true if str is null or its length is 0
   * @since 1.0.0
   */
  public static boolean isEmpty(String str) {
    return (str == null || str.isEmpty());
  }

  /**
   * Checks whether the passed in string is a palindrome
   *
   * @param str the string to be checked
   * @return true or false based on whether the string is a palindrome
   * @since 1.1.0
   */
  public static boolean isPalindrome(String str) {
    return !isBlank(str) &&
        str.replaceAll(" ", "").equalsIgnoreCase(reverse(str.replaceAll(" ", "")));
  }

  /**
   * Reverse the string passed in
   *
   * @param str the string to be reversed
   * @return a reversed version of the string passed in
   * @since 1.1.0
   */
  public static String reverse(String str) {
    return isBlank(str) ? str : new StringBuilder().append(str).reverse().toString();
  }

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param maxWidth the expected maxWidth of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @return the original string if the length of the string is smaller than maxWidth
   * @since 1.0.0
   */
  public static String truncate(String str, int maxWidth, String trimPosition) {
    return truncate(str, maxWidth, trimPosition, false);
  }

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param maxWidth the expected maxWidth of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @param includeEllipsis whether the ellipsis characters should be included
   * @return the original string if the length of the string is smaller than maxWidth, otherwise the
   * truncated string
   * @since 1.0.0
   */
  public static String truncate(String str, int maxWidth, String trimPosition,
      boolean includeEllipsis) {
    if (isBlank(str) || str.length() < maxWidth) {
      return str;
    }
    if (trimPosition.equals(TruncateAt.START.toString())) {
      return includeEllipsis ? str.substring(0, maxWidth) + "..." : str.substring(0, maxWidth);
    } else if (trimPosition.equals(TruncateAt.END.toString())) {
      return includeEllipsis ? "..." + str.substring(maxWidth) : str.substring(maxWidth);
    }
    return str;
  }
}
