package com.jpmorgan.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      driver = createDriver();
    }
    return driver;
  }

  private static WebDriver createDriver() {
    String chromeDriverPath =
      System.getProperty("user.dir") +
      "/src/main/resources/drivers/chromedriver.exe";

    System.setProperty("webdriver.chrome.driver", chromeDriverPath);

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized"); // Maximize the browser window
    options.addArguments("--disable-infobars"); // Disable info bars
    options.addArguments("--disable-extensions"); // Disable extensions

    driver = new ChromeDriver(options);

    return driver;
  }
}
