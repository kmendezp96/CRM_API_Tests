Feature: Create a Order
  As a cmr user
  I want to create a order
  So clients can order it

Background:
  Given I have access to CRM "Order" service with "write permission"

@Positive
Scenario Outline: Creating a valid new order with a valid Product
  When I send a new order with: "<status>", "<quantity>", "<productId>", "<costumerId>"
  Then Order has the attributes that i set
  And the system response with a "200" status code
  Examples:
    |status|quantity|productId|costumerId|
    |Requested|2|42fa141d-7999-47d2-9ade-4eb514cce4c7|0b3eaffb-2b57-4a94-ae64-c46f42daca50|

@Negative
Scenario Outline: Can't create a new order with invalid input
  When I send a new order with: "<status>", "<quantity>", "<productId>", "<costumerId>"
  Then the system response with a "400" status code
  Examples:
    |status|quantity|productId|costumerId|
    |Nothing|0      |0|0|

Scenario Outline: Can't create a new order when quantity of the products is lower than the one asked in the order
  When I send a new order with: "<status>", "<quantity>", "<productId>", "<costumerId>"
  Then the system response with a "400" status code
  Examples:
    |status|quantity|productId|costumerId|
    |Requested|1000|65f2de93-3c65-4cf6-9ac6-90e7e0597d16|0b3eaffb-2b57-4a94-ae64-c46f42daca50|

  @Alternative
  Scenario: Can't create an empty order
    When I send a new order with nothing
    Then the system response with a "400" status code