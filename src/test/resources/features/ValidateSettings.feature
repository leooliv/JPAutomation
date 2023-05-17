@Settings @RegressionTest
Feature: Performing positive and negative flows of account login
    As as user I
    want to be able to visit, interact and edit my settings page

    @UpdateSettings
    Scenario Outline: Update username and bio text
        Given the user is logged into the platform
        When the user clicks settings link
        Then update Username and Bio fields
        And click Update Settings button
