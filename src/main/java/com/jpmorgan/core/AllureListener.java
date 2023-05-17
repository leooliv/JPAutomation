package com.jpmorgan.core;

import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCaseFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureListener extends AllureCucumber7Jvm {

  private static final Logger logger = LoggerFactory.getLogger(
    AllureListener.class
  );

  @Override
  public void setEventPublisher(EventPublisher publisher) {
    publisher.registerHandlerFor(
      TestCaseFinished.class,
      testCaseFinished -> {
        System.out.println("Test finished 1");
        if (testCaseFinished.getResult().getStatus().is(Status.FAILED)) {
          if (ChromeDriverFactory.getDriver() != null) Allure
            .getLifecycle()
            .addAttachment(
              "image error - " + LocalDate.now(),
              "image/png",
              "png",
              saveScreenShootPNG()
            );
        }

        if (testCaseFinished.getResult().getStatus().is(Status.PASSED)) {
          if (ChromeDriverFactory.getDriver() != null) Allure
            .getLifecycle()
            .addAttachment(
              "print screen - " + LocalDate.now(),
              "image/png",
              "png",
              saveScreenShootPNG()
            );
        }
      }
    );
    super.setEventPublisher(publisher);
  }

  public ByteArrayInputStream saveScreenShootPNG() {
    return new ByteArrayInputStream(
      ((TakesScreenshot) ChromeDriverFactory.getDriver()).getScreenshotAs(
          OutputType.BYTES
        )
    );
  }
}
