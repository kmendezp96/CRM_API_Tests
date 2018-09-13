Feature: Select a Product
  As a cmr user
  I want to select a product
  So clients can see the product characteristics

  Background:
    Given I have access to CRM "Product" service with "only read permission"

  Scenario: Selecting all products
    When I search for all products
    Then the system response with a "200" status code
    And the system returns all products with specific format

  Scenario Outline: Selecting a valid product
    When I search for product with: "<productId>"
    Then I can see the specified product
    And the system response with a "200" status code
    Examples:
      |productId|
      |08027ea7-e15c-4f15-86a2-ec8b1a1352e5|

  Scenario Outline: Selecting an invalid product
    When I search for product with: "<productId>"
    Then the system response with a "404" status code
    Examples:
      |productId|
      |10|
