@SignIn @RegressionTest
Feature: Performing positive and negative flows of account login
    As as user I
    want to be able to verify the account login flow

    @SignInValid @HappyPath
    Scenario Outline: Signing in an account with correct values for email and password
        Given the user is on home page
        And click the sign in link
        When the user fills the sign in fields <email> <password>
        And click Sign In button
        Then it should be redirected to the logged home page
        Examples:
            | email                     | password |
            | ilia-jpmorgan@mailsac.com | Test.123 |
    @SignOut
    Scenario Outline: Signing out of an account
        Given the user is logged into the platform
        When the user clicks settings link
        And click the logout button
        Then it should be logged out of the platform

