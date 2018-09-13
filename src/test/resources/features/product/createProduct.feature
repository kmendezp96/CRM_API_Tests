Feature: Create a Product
  As a cmr user
  I want to create a product
  So clients can order it

Background:
  Given I have access to CRM "Product" service with "write permission"

@Positive
Scenario Outline: Creating a valid new product
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then Product has the attributes that i set
  And the system response with a "200" status code
  Examples:
  |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
  |Available|Flat Screen Monitors|Optimum Hi-Resolution max. 1600 x 1200 @ 85Hz, Dot Pitch: 0.24mm                           |KG|23|HT-1035|Computer Components|20|Flat Basic|EUR|cm|93dd1e02-a15b-49d3-ba87-0dd55e3cf297|1|PC|14|399 |41|39|
  |Available|Books|In the tightly knit world of Boston medicine, the Randall family reigns supreme. When heart surgeon J. D. |GR|50|BT-4567|Books|20|A Case of Need: A Novel|US|cm|93dd1e02-a15b-49d3-ba87-0dd55e3cf297|2|BK|30|7.19|78|65|

@Negative
Scenario Outline: Can't create a new product with invalid input
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then the system response with a "400" status code
  Examples:
  |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
  |Available|Books|When a mutilated body is found hanging in a seedy motel in Philadelphia, forensics specialist Liam Dwyer assumes the crime scene will be business as usual.|gr|50|BTYU-67|Books|depth|What Have You Done|0|234|93dd1e02-a15b-49d3-ba87-0dd55e3cf297|US|ERT|CM|$11.99|18|25|

@Alternative
Scenario Outline: Can't create a repeated input for a new product
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then the system response with a "400" status code
  Examples:
    |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
    |Available|Flat Screen Monitors|Optimum Hi-Resolution max. 1600 x 1200 @ 85Hz, Dot Pitch: 0.24mm                           |KG|23|HT-1035|Computer Components|20|Flat Basic|EUR|cm|                                  |1|PC|14|399 |41|39|

@Alternative
Scenario Outline: Can't create a valid new product with invalid supplier
  When I send a new product with "<status>", "<category>", "<description>", "<weightUnit>", "<quantity>", "<productId>", "<mainCategory>", "<depth>", "<name>", "<currencyCode>", "<dimUnit>", "<supplierId>", "<taxTarifCode>", "<UoM>", "<weightMeasure>", "<price>", "<height>" and "<width>"
  Then the system response with a "400" status code
  Examples:
    |status|category|description|weightUnit|quantity|productId|mainCategory|depth|name|currencyCode|dimUnit|supplierId|taxTarifCode|UoM|weightMeasure|price|height|width|
    |Available|Books|Germany, 1942. Franciscan friar Anton Starzmann is stripped of his place in the world when his school is seized by the Nazis. He relocates to a small German hamlet to wed Elisabeth Herter, a widow who seeks a marriage |100gr|50|BTYU-67|Books|depth|The Ragged Edge of Night|23|234|645sdgd-456dh|US|ERT|CM|$11.99|78|65|

@Alternative
Scenario: Can't create an empty product
  When I send a new product with nothing
  Then the system response with a "400" status code