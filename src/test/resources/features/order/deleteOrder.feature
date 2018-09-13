Feature: Delete a Product
  As a cmr user
  I want to delete a product
  So product is not available

  Background:
    Given I have access to CRM "Order" service with "all permission"

  Scenario Outline: Deleting a valid order
    When I delete the order with: "<orderId>"
    Then the system response with a "204" status code
    And I wont be able to see the order with that "<orderId>"
    Examples:
      |orderId|
      |e1ef4f32-63c8-4692-ade7-fcfdc79b46cc|

  Scenario Outline: Deleting an invalid order
    When I delete the order with: "<orderId>"
    Then the system response with a "400" status code
    Examples:
      |orderId|
      |10|

