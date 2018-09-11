Feature: Create a Product
  As a cmr user
  I want to create a product
  So clients can order it

Background:
  Given I have access to CRM "Product" service with "write permission"

Scenario Outline: Creating a valid new product
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then the system response with a "201" status code
  Examples:
  |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
  |Available|Books|In the tightly knit world of Boston medicine, the Randall family reigns supreme. When heart surgeon J. D. |100gr|50|BTYU-67|Books|depth|A Case of Need: A Novel|23|234|93dd1e02-a15b-49d3-ba87-0dd55e3cf297|US|ERT|CM|$7.19|78|65|


Scenario Outline: Invalid input for a new product
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then the system response with a "400" status code
  Examples:
  |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|

