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
      | id  |
      | 747b4e0d-882e-4308-bf7b-10ad826cbd3a |
      #| 4   |