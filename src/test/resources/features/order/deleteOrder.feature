Feature: Delete a Product
  As a cmr user
  I want to delete a product
  So product is not available

  Background:
    Given I have access to CRM "Order" service with "write permission"

  Scenario Outline: Deleting a valid product
    When I delete the product with: "<orderId>"
    Then the system response with a "204" status code
    Examples:
      |orderId|
      |1|
      |2|

  Scenario Outline: Deleting an invalid order
    When I delete the product with: "<orderId>"
    Then the system response with a "400" status code
    Examples:
      |orderId|
      |10|

