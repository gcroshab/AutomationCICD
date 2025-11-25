
@tag
Feature: Purchase order from Ecommerce website
	I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Posivite Test of submittin the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples:
      | name                | password    | productName |
      | anc.grosh@gmail.com | Kathmandu@1 | ZARA COAT 3 |
