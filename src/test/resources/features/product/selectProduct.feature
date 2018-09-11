Feature: Select a Product
  As a cmr user
  I want to select a product
  So clients can see the product characteristics

  Background:
    Given I have access to CRM "Product" service with "oonly read permission"

  Scenario: Selecting all products
    When I search for all products
    Then the system response with a "200" status code


  Scenario Outline: Selecting a valid product
    When I search for product with: "<productId>"
    Then the system response with a "200" status code
    Examples:
      |productId|
      |1|
      |2|
      |3|
      |4|

  Scenario Outline: Selecting an invalid product
    When I search for product with: "<productId>"
    Then the system response with a "404" status code
    Examples:
      |productId|
      |10|
      |20|
      |30|
      |40|
