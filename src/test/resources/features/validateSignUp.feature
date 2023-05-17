@SignUp @RegressionTest
Feature: Performing positive and negative flows of account creation
  As as user I
  want to be able to verify the account creation flow
  creating new accounts and checking it's methods

  @SignUpValid @HappyPath
  Scenario Outline: Create an account with correct values for email and password
    Given the user is on home page
    And click the sign up link
    When the user fills the registration fields
    And click Sign Up button
    Then it should be redirected to the logged home page
