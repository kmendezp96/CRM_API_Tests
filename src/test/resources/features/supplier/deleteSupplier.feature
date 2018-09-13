Feature: delete supplier
  As a CRM administrator
  I want to delete one supplier
  So the unnecessary suppliers won't be on the system

  Scenario Outline: delete a supplier
    Given I have access to CRM "supplier" service with "all permission"
    When i delete the supplier with"<id>"
    Then the system response with a "204" status code
    And the supplier with that "<id>" must not exists
    Examples:
      | id  |
      | f574d849-4de3-4542-b0ab-f5dc26a5b339 |
