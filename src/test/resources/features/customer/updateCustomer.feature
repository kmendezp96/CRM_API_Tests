Feature: update customer
  As a CRM administrator
  I want to change the customer attributes
  So i can update the customer with the new information

  Scenario Outline: Update a new customer with invalid id
    Given I have access to the CRM service with write permissions
    When i send a "put" request to customer/"<id>" with the fields i want to update ("<firstName>", "<lastName>", "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>" or "<age>")
    Then the customer with that "<id>" must not be updated
    And the system respons with "400" status code
    Examples:
      | id  | firstName  | lastName | address             | city | phoneNumber  | phoneNumberType | email            | age |
      | 3   | David      | Garza    | 1066  Camden Street | Reno | 775-378-6153 | mobile          |                  | 32  |
      | 4   |            |          |                     |      |              |                 | denA32@gmail.com |     |

  """Scenario Outline: Update a new customer with invalid id
    Given I have access to the CRM service with write permissions
    When i send a "put" request to customer/"<id>" with the fields i want to update ("<firstName>", "<lastName>", "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>" or "<age>")
    Then the customer with that "<id>" must not be updated
    And the system respons with "400" status code
    Examples:
      | id                                      | firstName  | lastName | address             | city | phoneNumber  | phoneNumberType | email            | age |
      | 0b3eaffb-2b57-4a94-ae64-c46f42daca50    | David      | Garza    | 1066  Camden Street | Reno | 775-378-6153 | mobile          |                  | 32  |
      | 2e13c549-8d83-46e5-9f40-c87de47159a3    |            |          |                     |      |              |                 | denA32@gmail.com |     |
  """
