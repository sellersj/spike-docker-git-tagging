package com.github.sellersj.docker.spike;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldTest {

  @Test
  public void test() {
    String actual = HelloWorld.getGreeting();
    assertEquals("Hello world", actual);
  }

}
