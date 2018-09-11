Feature: create customer
  As a CRM administrator
  I want to create a customer
  So i can subscribe them of the system
  Background:
    Given I have access to CRM "customer" service with "write permission"

  Scenario Outline:  Create a new customer
    When i send a post request with the "<firstName>", "<lastName>", "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>" and "<age>"
    #Then i should see the new "<customer>" in the customers list.
    Then the system response with a "201" status code
    Examples:
      | firstName   | lastName    | address              | city        | phoneNumber  | phoneNumberType | email             | age |
      | Juan        | Rodriguez   | 2449  Bassell Avenue | Little Rock | 501-779-1985 | home            | jRodr@gmail.com   | 21  |
      | Antonio      | Velasquez  | 2694  Sundown Lane   | Illinois    | 708-204-8662 | mobile          | vel2123@gmail.com | 43  |

