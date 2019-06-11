package com.github.giorgosart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.giorgosart.StringUtils;
import com.github.giorgosart.TruncateAt;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void defaultString() {
    assertEquals(StringUtils.defaultString(null, "test"), "test");
    assertEquals(StringUtils.defaultString("test", "testing"), "test");
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

    assertNull(StringUtils.truncate(null, 2, TruncateAt.END.name(), true));
  }
}
