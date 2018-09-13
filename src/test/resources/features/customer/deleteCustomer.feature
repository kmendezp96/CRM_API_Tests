Feature: delete customer
  As a CRM administrator
  I want to delete a customer
  So the unnecessary customers won't be on the system

  Scenario Outline: delete a customer
    Given I have access to CRM "customer" service with "all permission"
    When i delete the customer with"<id>"
    Then the system response with a "204" status code
    And the customer with that "<id>" must not exists
    Examples:
      | id                                   |
      | 973e3bd6-aee8-4764-add1-1e867dddc889 |
