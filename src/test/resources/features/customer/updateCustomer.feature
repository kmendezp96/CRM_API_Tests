Feature: update customer
  As a CRM administrator
  I want to change the customer attributes
  So i can update the customer with the new information

  Scenario Outline: Update a new customer
    Given I have access to CRM "customer" service with "all permission"
    And the customer with "<id>" exists
    When i send a put request to specifying the customer "<id>" with the fields "<firstName>", "<lastName>", "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>" or "<age>" that want to update
    Then the system response with a "200" status code
    And the customer with that "<id>" must have the updated attributes

    Examples:
      | id                                     | firstName  | lastName | address             | city | phoneNumber  | phoneNumberType | email                        | age |
      #| 247ae7a7-1078-4d36-9af0-5243e1ed7da9   | Dario      |          |                     |      | 775-458-6153 | mobile          |      anto@gmail.com          | 33  |
      | 2e13c549-8d83-46e5-9f40-c87de47159a3   | Kevin      | Paez     | 1066  Camden Street | Reno | 775-378-6153 | mobile          |      algo@gmail.com          | 32  |
