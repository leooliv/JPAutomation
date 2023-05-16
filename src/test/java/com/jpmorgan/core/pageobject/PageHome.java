package com.jpmorgan.core.pageobject;

import com.jpmorgan.core.PageModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends PageModel {

  @FindBy(xpath = "//a[text()='Home']")
  public WebElement homeLink;

  @FindBy(xpath = "//a[text()='conduit']")
  public WebElement conduitLink;

  @FindBy(xpath = "//a[text()='Sign in']")
  public WebElement signInLink;

  @FindBy(xpath = "//a[text()='Sign up']")
  public WebElement signUpLink;

  @FindBy(xpath = "//a[text()='Global Feed']")
  public WebElement globalFeedLink;

  @FindBy(xpath = "//a[text()='Sign in to see your Feed']")
  public WebElement yourFeedSignInLink;
}
