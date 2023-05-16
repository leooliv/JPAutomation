package com.jpmorgan.core.steps;

import static com.jpmorgan.core.ChromeDriverFactory.getDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepsHooks {

  @Before
  public void setup() {
    getDriver().get("https://realworld.svelte.dev");
  }

  public ByteArrayInputStream saveScreenShootPNG() {
    return new ByteArrayInputStream(
      ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)
    );
  }

  @After
  public void tearDown(Scenario scenario) {
    String scenarioName =
      scenario.getStatus() + " - " + scenario.getName() + LocalDate.now();

    if (getDriver() != null) Allure
      .getLifecycle()
      .addAttachment(scenarioName, "image/png", "png", saveScreenShootPNG());
    System.out.println("Driver after: ");
  }

  @AfterAll
  public static void tearDown() {
    getDriver().quit();
  }
}
