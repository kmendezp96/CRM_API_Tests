Feature: Select an Order
  As a cmr user
  I want to select an order
  So clients can see the order characteristics

  Background:
    Given I have access to CRM "Order" service with "only read permission"

  Scenario: Selecting all orders
    When I search for all orders
    Then the system response with a "200" status code
    And the system returns all orders with specific format

  Scenario Outline: Selecting a valid order
    When I search for order with: "<orderId>"
    Then I can see the specified order
    And the system response with a "200" status code
    Examples:
      |orderId|
      |7325026d-4abc-4d73-8502-e94500167d05|


  Scenario Outline: Selecting an invalid order
    When I search for order with: "<orderId>"
    Then the system response with a "404" status code
    Examples:
      |orderId|
      |10|
