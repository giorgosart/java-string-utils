package com.github.giorgosart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StringUtilsTest {

  @Test
  void areAnagram() {
    assertTrue(StringUtils.areAnagram("nag a ram", "anagram"));
    assertTrue(StringUtils.areAnagram("evil", "vile"));
    assertTrue(StringUtils.areAnagram("eviL", "Vile"));
    assertTrue(StringUtils.areAnagram("a gentleman", "elegant man"));
    assertTrue(StringUtils.areAnagram("eleven plus two", "twelve plus one"));

    assertFalse(StringUtils.areAnagram(null, null));
    assertFalse(StringUtils.areAnagram("first", null));
    assertFalse(StringUtils.areAnagram(null, "second"));
    assertFalse(StringUtils.areAnagram("one", "two"));
    assertFalse(StringUtils.areAnagram("three", "false"));
  }

  @Test
  void contains() {
    assertTrue(StringUtils.contains("test", "te"));
    assertFalse(StringUtils.contains(null, "te"));
    assertFalse(StringUtils.contains(null, null));
    assertFalse(StringUtils.contains("test", null));

    assertTrue(StringUtils.contains("test", "TE", true));
    assertTrue(StringUtils.contains("Test", "t", true));
  }

  @Test
  void defaultString() {
    String[] testInput = new String[]{"a", "b", "c", "d", "e", "f", "g"};
    assertEquals(StringUtils.defaultString(null, "test"), "test");
    assertEquals(StringUtils.defaultString("", "test"), "test");
    assertEquals(StringUtils.defaultString("test", "testing"), "test");

    assertEquals(StringUtils.defaultString("test", new String[]{}), "test");
    assertEquals(StringUtils.defaultString(null, new String[]{}), "");
    assertTrue(Arrays.asList(testInput).contains(StringUtils.defaultString("", testInput)));
  }

  @Test
  void randomString() {
    String[] testInput = new String[]{"a", "b", "c", "d", "e", "f", "g"};
    assertTrue(Arrays.asList(testInput).contains(StringUtils.randomString(testInput)));
    assertEquals(StringUtils.randomString(new String[]{}), "");
    assertEquals(StringUtils.randomString(null), "");
  }

  @Test
  void iBlank() {
    assertEquals(StringUtils.isBlank(null), Boolean.TRUE);
    assertEquals(StringUtils.isBlank(""), Boolean.TRUE);
    assertEquals(StringUtils.isBlank(" "), Boolean.TRUE);
    assertEquals(StringUtils.isBlank("some string"), Boolean.FALSE);
    assertEquals(StringUtils.isBlank("     "), Boolean.TRUE);
    assertEquals(StringUtils.isBlank("   some string   "), Boolean.FALSE);
  }

  @Test
  void isEmpty() {
    assertEquals(StringUtils.isEmpty(null), Boolean.TRUE);
    assertEquals(StringUtils.isEmpty(""), Boolean.TRUE);
    assertEquals(StringUtils.isEmpty(" "), Boolean.FALSE);
    assertEquals(StringUtils.isEmpty("some string"), Boolean.FALSE);
    assertEquals(StringUtils.isEmpty("     "), Boolean.FALSE);
    assertEquals(StringUtils.isEmpty("   some string   "), Boolean.FALSE);
  }

  @Test
  void isPalindrome() {
    assertFalse(StringUtils.isPalindrome(null));
    assertTrue(StringUtils.isPalindrome("aabbsbbaa"));
    assertTrue(StringUtils.isPalindrome("star buttons not tub rats"));
  }

  @Test
  void length() {
    assertEquals(-1, StringUtils.length(null));
    assertEquals(0, StringUtils.length(""));
    assertEquals(4, StringUtils.length("test"));
  }

  @Test
  void reverse() {
    assertEquals(StringUtils.reverse("aabbccdd"), "ddccbbaa");
    assertEquals(StringUtils.reverse(""), "");
    assertNull(StringUtils.reverse(null));
  }

  @Test
  void truncate() {
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.START.name()), "te");

    assertEquals(StringUtils.truncate("test", 10, TruncateAt.START.name(), false), "test");
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.START.name(), false), "te");
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.END.name(), false), "st");

    assertEquals(StringUtils.truncate("test", 10, TruncateAt.START.name(), true), "test");
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.START.name(), true), "te...");
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.END.name(), true), "...st");
    assertEquals(StringUtils.truncate("test", 2, TruncateAt.END.name(), true, "--"), "--st");

    assertNull(StringUtils.truncate(null, 2, TruncateAt.END.name(), true));
  }

  @Test
  void toKebabCase() {
    assertEquals("test-test", StringUtils.toKebabCase("test test"));
    assertEquals("", StringUtils.toKebabCase(""));
    assertEquals(null, StringUtils.toKebabCase(null));
  }

  @Test
  void toSnakeCase() {
    assertEquals("test_test", StringUtils.toSnakeCase("test test"));
    assertEquals("", StringUtils.toSnakeCase(""));
    assertEquals(null, StringUtils.toSnakeCase(null));
  }
}
