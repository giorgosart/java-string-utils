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
   * Contacts a case sensitive search on the string passed in
   *
   * @param str the string to be examined
   * @param searchStr the search string
   * @return true if the searchStr is found in the passed in string otherwise false
   * @since 1.2.0
   */
  public static boolean contains(String str, String searchStr) {
    return contains(str, searchStr, false);
  }

  /**
   * Contacts either a case sensitive or case insensitive search on the string passed in based on the flag ignoreCase
   *
   * @param str the string to be examined
   * @param searchStr the search string
   * @param ignoreCase a flag to set the search algorithm to ignore the case or not
   * @return true if the searchStr is found in the passed in string otherwise false
   * @since 1.2.0
   */
  public static boolean contains(String str, String searchStr, boolean ignoreCase) {
    if (str == null || searchStr == null) {
      return false;
    }
    return ignoreCase ? str.toLowerCase().contains(searchStr.toLowerCase()) : str.contains(searchStr);
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
    return (isEmpty(str) || str.matches("^\\s*$"));
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
   * A null check implementation of the String.length() method
   *
   * @param str the string to be examined, can be null
   * @return -1 if the string is null otherwise the length of the string that was passed in as an argument
   * @since 1.2.0
   */
  public static int length(String str) {
    return str != null ? str.length() : -1;
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
    return truncate(str, maxWidth, trimPosition, includeEllipsis, "...");
  }

  /**
   * Returns a truncated string based on the parameters passed in
   *
   * @param str the string to be examined, can be null
   * @param maxWidth the expected maxWidth of the string
   * @param trimPosition where should the string be truncated at, either beginning or end
   * @param includeEllipsis whether the ellipsis characters should be included
   * @param ellipseCharacter the character to be used to replace the truncated string
   * @return the original string if the length of the string is smaller than maxWidth, otherwise the
   * truncated string
   * @since 1.2.0
   */
  public static String truncate(String str, int maxWidth, String trimPosition,
      boolean includeEllipsis, String ellipseCharacter) {
    if (isBlank(str) || length(str) < maxWidth) {
      return str;
    }
    if (trimPosition.equals(TruncateAt.START.toString())) {
      return includeEllipsis ? str.substring(0, maxWidth) + ellipseCharacter : str.substring(0, maxWidth);
    } else if (trimPosition.equals(TruncateAt.END.toString())) {
      return includeEllipsis ? ellipseCharacter + str.substring(maxWidth) : str.substring(maxWidth);
    }
    return str;
  }


  /**
   *
   * @param str
   * @return
   * @since 1.2.0
   */
  public static String toKebabCase(String str){
    return isBlank(str) ? str : str.replaceAll(" ", "-");
  }
}
