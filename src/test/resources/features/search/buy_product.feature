@FeatureName:HU01_Buy_Products
Feature: I as a user want to buy a product

  @ScenarioName:buy_product
  Scenario Outline: buy a product
    Given Camilo enters in demoblaze
    When select the product <PRODUCT> in the category <CATEGORY>
    And go to cart and place order
    Then the message "Thank you for your purchase!" is displayed
    Examples:
    |PRODUCT|CATEGORY|
    |"Samsung galaxy"|"Phone"|
    |"MacBook air"|"Laptops"|
    |"ASUS Full HD"|"Monitors"|