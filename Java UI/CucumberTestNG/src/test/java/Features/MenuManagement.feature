Feature: Menu Management

  Background: Add third menu item
    Given I have a menu item with name "Cucumber Salad" and price 15
    When I add that menu item
    Then Menu Item with name "Cucumber Salad" should be added

  @SmokeTest
  Scenario: Add a menu item
    Given I have a menu item with name "Chicken sandwich" and price 15
    When I add that menu item
    Then Menu Item with name "Chicken sandwich" should be added


  @RegularTest
  Scenario: Add another menu item
    Given I have a menu item with name "Cucumber Salad" and price 15
    When I add that menu item
    Then Should display an error message "Duplicate Item"

  @NightlyBuildTest @RegularTest
  Scenario: Add third menu item
    Given I have a menu item with name "Cucumber" and price 15
    When I add that menu item
    Then Menu Item with name "Cucumber" should be added