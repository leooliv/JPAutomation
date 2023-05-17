package com.jpmorgan.core.pageobject;

import com.jpmorgan.core.PageModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProfile extends PageModel {

  @FindBy(xpath = "//a[@text()='Articles']")
  public WebElement profileArticlesLink;

  @FindBy(xpath = "//a[@text()='Favorites']")
  public WebElement profileFavoritesArticlesLink;

  @FindBy(xpath = "//a[contains(text(), 'Edit Profile Settings')]")
  public WebElement editProfileLink;
}
