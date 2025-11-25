
@tag
Feature: Purchase order from Ecommerce website
	I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page

  @ErrorValidation
  Scenario Outline: Title of your scenario outline 
  
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | name     | password  |
      | rosh@gmai.com  | Kathmandu |
      
