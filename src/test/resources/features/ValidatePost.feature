@SignIn @RegressionTest
Feature: Performing positive and negative flows related to posts in the platform
    As as user I
    want to be able to verify the account login flow

    @NewPostValid
    Scenario Outline: Making a new post
        Given the user is logged into the platform
        And the user clicks New Post link
        When the user clicks New Post link
        Then it should be redirected to the logged home page
