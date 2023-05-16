package com.jpmorgan.core;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebActions {

  protected static WebDriver driver;
  private static final Logger logger = LoggerFactory.getLogger(
    WebActions.class
  );

  public WebActions() {
    logger.info("Initializer driver ....");
    driver = ChromeDriverFactory.getDriver();
  }

  public WebActions click(WebElement element) {
    waitElement(element);
    logger.info("Clicking element: " + element);
    element.click();
    return this;
  }

  public WebActions typeEmail(WebElement element, String email) {
    logger.info("typing email: " + email);
    try {
      waitElement(element);
      element.sendKeys(email);
    } catch (Exception e) {
      throw new WebDriverException(
        "Unable to type the value: '" +
        email +
        "' in element: '" +
        element +
        "'"
      );
    }
    return this;
  }

  public WebActions typeValue(WebElement element, String value) {
    waitElement(element);
    logger.info("typing value" + value);
    element.sendKeys(value);
    return this;
  }

  public WebActions clearValue(WebElement element) {
    waitElement(element);
    logger.info("Clearing value " + element);
    element.clear();
    return this;
  }

  public WebActions elementIsVisible(WebElement element) {
    waitElement(element);
    element.isDisplayed();
    return this;
  }

  public WebActions waitElement(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    try {
      wait.until(
        ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element))
      );
    } catch (Exception e) {
      logger.error("Could not find element as expected: ");
      throw new WebDriverException("Could not find element as expected: ", e);
    }
    return this;
  }

  public WebActions waitTime(long seconds) {
    try {
      logger.warn("wait" + "'" + seconds + "' seconds");
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  protected void waitOfAllElements(List<WebElement> elements) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    try {
      wait.until(
        ExpectedConditions.refreshed(
          ExpectedConditions.visibilityOfAllElements(elements)
        )
      );
    } catch (Exception e) {
      logger.error("Could not find element as expected: ");
      throw new WebDriverException("Could not find element as expected: ", e);
    }
  }
}
