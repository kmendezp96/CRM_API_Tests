Feature: Update a Product
  As a cmr user
  I want to update a order
  So clients can see the changes

  Background:
    Given I have access to CRM "Order" service with "write permission"

  Scenario Outline: Updating an existing order with valid fields
    When I send an update to order with "<orderId>" with "<status>", "<quantity>", "<productId>", "<costumerId>"
    Then Order has the attributes that i set
    And the system response with a "200" status code
    Examples:
      |orderId|status|quantity|productId|costumerId|
      |969a5ac5-b802-41bd-bec9-21559d9ccfc8|Canceled|0|6be02e04-5852-4d8b-816f-79b984169b6f|0b3eaffb-2b57-4a94-ae64-c46f42daca50|

  Scenario Outline: Updating an not existing order
    When I send an update to order with not existing "<orderId>"
    Then the system response with a "404" status code
    Examples:
      |orderId|
      |10     |
