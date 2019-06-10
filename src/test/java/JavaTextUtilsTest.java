import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class JavaTextUtilsTest {

  @Test
  void defaultString() {
    assertEquals(JavaTextUtils.defaultString(null, "test"), "test");
    assertEquals(JavaTextUtils.defaultString("test", "testing"), "test");
  }

  @Test
  void iBlankTest() {
    assertEquals(JavaTextUtils.isBlank(null), Boolean.TRUE);
    assertEquals(JavaTextUtils.isBlank(""), Boolean.TRUE);
    assertEquals(JavaTextUtils.isBlank(" "), Boolean.TRUE);
    assertEquals(JavaTextUtils.isBlank("some string"), Boolean.FALSE);
    assertEquals(JavaTextUtils.isBlank("     "), Boolean.TRUE);
    assertEquals(JavaTextUtils.isBlank("   some string   "), Boolean.FALSE);
  }

  @Test
  void isEmptyTest() {
    assertEquals(JavaTextUtils.isEmpty(null), Boolean.TRUE);
    assertEquals(JavaTextUtils.isEmpty(""), Boolean.TRUE);
    assertEquals(JavaTextUtils.isEmpty(" "), Boolean.FALSE);
    assertEquals(JavaTextUtils.isEmpty("some string"), Boolean.FALSE);
    assertEquals(JavaTextUtils.isEmpty("     "), Boolean.FALSE);
    assertEquals(JavaTextUtils.isEmpty("   some string   "), Boolean.FALSE);
  }

  @Test
  void truncate() {
    assertEquals(JavaTextUtils.truncate("test", 10, TruncateAt.START, false), "test");
    assertEquals(JavaTextUtils.truncate("test", 2, TruncateAt.START, false), "te");
    assertEquals(JavaTextUtils.truncate("test", 2, TruncateAt.END, false), "st");

    assertEquals(JavaTextUtils.truncate("test", 10, TruncateAt.START, true), "test");
    assertEquals(JavaTextUtils.truncate("test", 2, TruncateAt.START, true), "te...");
    assertEquals(JavaTextUtils.truncate("test", 2, TruncateAt.END, true), "...st");

    assertNull(JavaTextUtils.truncate(null, 2, TruncateAt.END, true));
  }
}
