package com.jpmorgan.core;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {

  protected static WebDriver driver;

  public WebActions() {
    driver = ChromeDriverFactory.getDriver();
  }

  public WebActions click(WebElement element) {
    waitElement(element);
    element.click();
    return this;
  }

  public WebActions typeEmail(WebElement element, String email) {
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
    element.sendKeys(value);
    return this;
  }

  public WebActions clearValue(WebElement element) {
    waitElement(element);
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
      throw new WebDriverException("Could not find element as expected: ", e);
    }
    return this;
  }

  public WebActions waitTime(long seconds) {
    try {
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
      throw new WebDriverException("Could not find element as expected: ", e);
    }
  }
}
