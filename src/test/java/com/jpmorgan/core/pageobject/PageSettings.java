package com.jpmorgan.core.pageobject;

import com.jpmorgan.core.PageModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSettings extends PageModel {

  @FindBy(xpath = "//input[name='image']")
  public WebElement profilePictureFile;

  @FindBy(xpath = "//input[name='username']")
  public WebElement profileUsernameField;

  @FindBy(xpath = "//textarea[@name='bio']")
  public WebElement aboutYouField;

  @FindBy(xpath = "//input[name='email']")
  public WebElement profileEmailField;

  @FindBy(xpath = "//input[name='password']")
  public WebElement newPasswordField;

  @FindBy(
    xpath = "//button[@class='btn btn-lg btn-primary pull-xs-right' and text()='Update Settings']"
  )
  public WebElement updateSettingsButton;

  @FindBy(
    xpath = "//button[@class='btn btn-outline-danger' and contains(text(), 'Or click here to logout.')]"
  )
  public WebElement logOutButton;
}
