package com.jpmorgan.core.pageobject;

import com.jpmorgan.core.PageModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSign extends PageModel {

  @FindBy(xpath = "//input[@name='username']")
  public WebElement usernameField;

  @FindBy(xpath = "//input[@name='email']")
  public WebElement emailField;

  @FindBy(xpath = "//input[@name='password']")
  public WebElement passwordField;

  @FindBy(
    xpath = "//button[@class='btn btn-lg btn-primary pull-xs-right' and text()='Sign up']"
  )
  public WebElement signUpButton;

  @FindBy(
    xpath = "//button[@class='btn btn-lg btn-primary pull-xs-right' and text()='Sign in']"
  )
  public WebElement signInButton;

  @FindBy(xpath = "//a[text()='Have an account?']")
  public WebElement haveAccountLink;

  @FindBy(xpath = "//a[text()='Need an account?']")
  public WebElement needAccountLink;
}
