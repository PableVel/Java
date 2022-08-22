Feature: Data Tables
@ListofStrings
  Scenario: Bill Amount Gneratin
    Given I placed an order for the following items
    |Cucumber Sandwich|2|20|
    When I generate the bill
    Then a bill for $40 should be generated


@ListofListofStrings
  Scenario: Bill Amount Gneratin
    Given I placed an order for the following items
      |Cucumber Sandwich|2|20|
      |Cucumber |22|25|
    When I generate the bill
    Then a bill for $40 should be generated


  @ListofMaps
  Scenario: Bill Amount Gneratin
    Given I placed an order for the following items
      |ItemName         |Units|Unitprice|
      |Cucumber Sandwich|2    |20|
      |Cucumber Salad   |22   |25|
    When I generate the bill
    Then a bill for $40 should be generated