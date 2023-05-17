package com.jpmorgan.core.steps;

import com.jpmorgan.core.WebActions;
import com.jpmorgan.core.pageobject.PageHome;
import com.jpmorgan.core.pageobject.PageSign;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsSignIn extends WebActions {

  private final PageHome homePg = new PageHome();
  private final PageSign signPg = new PageSign();

  @And("click the sign in link")
  public void clickSignInLink() {
    click(homePg.signInLink);
  }

  @When("the user fills the sign in fields {} {}")
  public void fillRegistrationFields(String email, String password) {
    typeValue(signPg.emailField, email)
      .typeValue(signPg.passwordField, password);
  }

  @And("click Sign In button")
  public void clickSignInButton() {
    click(signPg.signInButton);
  }
}
