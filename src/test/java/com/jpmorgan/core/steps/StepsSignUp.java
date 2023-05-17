package com.jpmorgan.core.steps;

import com.github.javafaker.Faker;
import com.jpmorgan.core.WebActions;
import com.jpmorgan.core.pageobject.PageHome;
import com.jpmorgan.core.pageobject.PageSign;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsSignUp extends WebActions {

  private final PageHome homePg = new PageHome();
  private final PageSign signPg = new PageSign();
  Faker faker = new Faker();

  @Given("the user is on home page")
  public void checkIfHomePage() {
    waitElement(homePg.globalFeedLink);
  }

  @And("click the sign up link")
  public void clickSignUpLink() {
    click(homePg.signUpLink);
  }

  @And("click Sign Up button")
  public void clickSignUpButton() {
    click(signPg.signUpButton);
  }

  @When("the user fills the registration fields")
  public void fillRegistrationFields() {
    String username = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    System.out.println(username);
    System.out.println(email);
    System.out.println(password);

    typeValue(signPg.usernameField, username)
      .typeValue(signPg.emailField, email)
      .typeValue(signPg.passwordField, password);
  }

  @Then("it should be redirected to the logged home page")
  public void checkIfLoggedHomePage() {
    waitElement(homePg.globalFeedLink);
  }
}
