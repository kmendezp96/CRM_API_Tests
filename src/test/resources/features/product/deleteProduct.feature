Feature: Delete a Product
  As a cmr user
  I want to delete a product
  So product is not available}

  Background:
    Given I have access to CRM "Product" service with "write permission"

  Scenario Outline: Deleting a valid product
    When I delete the product with: "<productId>"
    Then the system response with a "202" status code
    Examples:
      |productId|
      |1|
      |2|

  Scenario Outline: Deleting an invalid product
    When I delete the product with: "<productId>"
    Then the system response with a "400" status code
    Examples:
      |productId|
      |10|

