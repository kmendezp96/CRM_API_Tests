Feature: Delete a Product
  As a cmr user
  I want to delete a product
  So product is not available}

  Background:
    Given I have access to CRM "Product" service with "write permission"

  Scenario Outline: Deleting a valid product
    When I delete the product with: "<productId>"
    Then the system response with a "202" status code
    And I wont be able to see the product with that "<productId>"
    Examples:
      |productId|
      |1a3adf91-8cc2-4116-9a8e-adc9b8cec7b8|
      |312b358b-50e0-46b2-a120-bae14bde17a9|

  Scenario Outline: Deleting an invalid product
    When I delete the product with: "<productId>"
    Then the system response with a "400" status code
    Examples:
      |productId|
      |10|

