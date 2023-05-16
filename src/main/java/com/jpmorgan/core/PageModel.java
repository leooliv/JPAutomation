package com.jpmorgan.core;

import org.openqa.selenium.support.PageFactory;

public class PageModel {

  public PageModel() {
    PageFactory.initElements(ChromeDriverFactory.getDriver(), this);
  }
}
