Feature: Update a Product
  As a cmr user
  I want to update a product
  So clients can see the changes

  Background:
    Given I have access to CRM "Product" service with "all permission"

  Scenario Outline: Updating an existing product with valid fields
    When I send an update to product with "<id>" with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
    Then Product has the attributes that i set
    And the system response with a "204" status code
    Examples:
      |id|status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
      |7af036b8-5710-4b1b-9f24-bb0691c0b2fc|Available|Music|Mikro MK2 Groove Production Studio, Black|KG|10|MK-6598|Software|4|Native Instruments Maschine|US|CM|93dd1e02-a15b-49d3-ba87-0dd55e3cf297|1|PC|14|299|50|50|

  Scenario Outline: Updating an not existing product
    When I send an update to product with not existing "<id>"
    Then the system response with a "400" status code
    Examples:
      |id|
      |10|
