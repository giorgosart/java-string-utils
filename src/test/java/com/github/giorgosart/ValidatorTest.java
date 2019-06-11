package com.github.giorgosart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

  @Test
  void iBlankTest() {
    assertEquals(Validator.isBlank(null), Boolean.TRUE);
    assertEquals(Validator.isBlank(""), Boolean.TRUE);
    assertEquals(Validator.isBlank(" "), Boolean.TRUE);
    assertEquals(Validator.isBlank("some string"), Boolean.FALSE);
    assertEquals(Validator.isBlank("     "), Boolean.TRUE);
    assertEquals(Validator.isBlank("   some string   "), Boolean.FALSE);
  }

  @Test
  void isEmptyTest() {
    assertEquals(Validator.isEmpty(null), Boolean.TRUE);
    assertEquals(Validator.isEmpty(""), Boolean.TRUE);
    assertEquals(Validator.isEmpty(" "), Boolean.FALSE);
    assertEquals(Validator.isEmpty("some string"), Boolean.FALSE);
    assertEquals(Validator.isEmpty("     "), Boolean.FALSE);
    assertEquals(Validator.isEmpty("   some string   "), Boolean.FALSE);
  }
}
