Feature: update supplier
  As a CRM administrator
  I want to change the supplier attributes
  So i can update the suppliers with new information

  Scenario Outline: Update supplier
    Given I have access to CRM "supplier" service with "all permission"
    And the supplier with "<id>" exists
    When i send a put request to specifying the supplier "<id>" with the fields "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>", "<supplierName>", "<twitter>" and "<url>" that want to update
    Then the system response with a "200" status code
    And the supplier with that "<id>" must have the updated attributes
    Examples:
     | id                                   | address                  | city         | phoneNumber  | phoneNumberType | email            | supplierName | twitter    | url                       |
     | 0cc71f38-2321-4b13-aeb3-16f7ef4cc3dd | 3920  Boundary Street    | Jacksonville | 757-273-4910 | mobile          | sup5@gmail.com   | supplier5    | @supplier5 | https://www.supplier5.com |
     | 254cee94-2dbc-4ab6-aaa3-96112a7640d1 | 2734  Spring Haven Trail | Woodport     | 609-516-1691 | mobile          | sup7@gmail.com   | supplier7    | @supplier7 | https://www.supplier7.com |