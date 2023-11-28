@FeatureName:HU02_Register_User
Feature: I as a user want to register in demoblaze

  @ScenarioName:sign_up
  Scenario: register a user
    Given Camilo enters in demoblaze
    When He enters his data in the singup and log in
    Then username is displayed
