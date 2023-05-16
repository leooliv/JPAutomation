package com.jpmorgan.core.steps;

import static com.jpmorgan.core.ChromeDriverFactory.getDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class StepsHooks {

  @Before
  public void setup() {
    getDriver().get("https://realworld.svelte.dev");
  }

  @AfterAll
  public static void tearDown() {
    getDriver().quit();
  }
}
