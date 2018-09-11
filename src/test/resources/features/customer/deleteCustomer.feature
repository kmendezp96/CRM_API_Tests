Feature: delete customer
  As a CRM administrator
  I want to delete a customer
  So the unnecessary customers won't be on the system

  Scenario Outline: delete a customer
    Given I have access to the CRM service with write permissions
    When i "delete" the customer with"<id>"
    Then the customer with that "<id>" must not exists
    And the system respons with "204" status code
    Examples:
      | id  |
      | 3   |
      | 4   |