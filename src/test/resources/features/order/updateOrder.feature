Feature: Update a Product
  As a cmr user
  I want to update a order
  So clients can see the changes

  Background:
    Given I have access to CRM "Order" service with "write permission"

  Scenario Outline: Updating an existing order with valid fields
    When I send an update to order with "<orderId>"
    And the order has: "<status>", "<quantity>", "<productId>", "<costumerId>"
    Then the system response with a "200" status code
    Examples:
      |orderId|status|quantity|productId|costumerId|

  Scenario Outline: Updating an not existing order
    When I send an update to order with "<orderId>"
    And the order has: "<status>", "<quantity>", "<productId>", "<costumerId>"
    Then the system response with a "404" status code
    Examples:
      |status|quantity|productId|costumerId|

  Scenario Outline: Updating an existing order with invalid fields
    When I send an update to order with "<id>"
    And the order has: "<status>", "<quantity>", "<productId>", "<costumerId>"
    Then the system response with a "408" status code
    Examples:
      |status|quantity|productId|costumerId|
