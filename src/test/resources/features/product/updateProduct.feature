Feature: Update a Product
  As a cmr user
  I want to update a product
  So clients can see the changes

  Background:
    Given I have access to CRM "Product" service with "write permission"

  Scenario Outline: Updating an existing product with valid fields
    When I send an update to product with "<productId>"
    And the product has "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
    Then the system response with a "204" status code
    Examples:
      |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|


  Scenario Outline: Updating an not existing product
    When I send an update to product with "<productId>"
    And the product has "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
    Then the system response with a "400" status code
    Examples:
      |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
