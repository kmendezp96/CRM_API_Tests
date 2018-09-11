Feature: Create a Order
  As a cmr user
  I want to create a order
  So clients can order it

Background:
  Given I have access to CRM "Order" service with "write permission"

Scenario Outline: Creating a valid new order with one Product
  When I send a new order with: "<status>", "<quantity>", "<productId>", "<costumerId>"
  Then the system response with a "200" status code
  Examples:
    |status|quantity|productId|costumerId|



Scenario Outline: Invalid input for a new order
  When I send a new order with: "<status>", "<quantity>", "<productId>", "<costumerId>"
  Then the system response with a "400" status code
  Examples:
    |status|quantity|productId|costumerId|

