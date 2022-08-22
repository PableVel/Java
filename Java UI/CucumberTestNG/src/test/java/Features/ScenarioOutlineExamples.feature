Feature: Final Bill Calculation
@ScenarioOutlineExample
  Scenario Outline: Customer bill Amount calculation
    Given I have a Customer
    And users enters initial bill amount as <InitialBillAmount>
    And Sales Tax Rate is <TaxRate> percent
    Then final bill amount calculate is <CalculatedBillAmount>

    Examples:
|InitialBillAmount|TaxRate|CalculatedBillAmount|
|100              |10     |110                 |
|200              |8      |208                 |
|100              |1.55   |101.55              |
