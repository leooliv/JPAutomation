package com.jpmorgan.core.pageobject;

import com.jpmorgan.core.PageModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNewPost extends PageModel {

  @FindBy(xpath = "//input[@name='title']")
  public WebElement titleField;

  @FindBy(xpath = "//input[@name='description']")
  public WebElement descriptionField;

  @FindBy(xpath = "//textarea[@name='body']")
  public WebElement articleTextField;

  @FindBy(
    xpath = "//button[@class='btn btn-lg pull-xs-right btn-primary' and text()='Publish Article']"
  )
  public WebElement publishButton;
}
