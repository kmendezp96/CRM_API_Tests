Feature: Select a Order
  As a cmr user
  I want to select a order
  So clients can see the order characteristics

  Background:
    Given I have access to CRM "Order" service with "only read permission"

  Scenario: Selecting all orders
    When I search for all orders
    Then the system response with a "200" status code


  Scenario Outline: Selecting a valid order
    When I search for order with: "<orderId>"
    Then the system response with a "200" status code
    Examples:
      |orderId|
      |1|
      |2|
      |3|
      |4|

  Scenario Outline: Selecting an invalid order
    When I search for order with: "<orderId>"
    Then the system response with a "404" status code
    Examples:
      |orderId|
      |10|
      |20|
      |30|
      |40|
