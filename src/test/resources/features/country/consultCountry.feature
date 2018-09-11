Feature: consult country
  As a CRM administrator
  I want to be able to see the countries information
  So i can know what countries are already in the system

  Background:
    Given I have access to CRM "Product" service with "write permission"

  Scenario Outline:  Consult a specific country
    When i send a get request with the "<id>" of an existent country
    Then the system should return one json with that country
    Examples:
      | id                                   |
      | 4482305e-b2d2-420e-8cda-65131a42786a |
      | 47ba827d-2e3c-420d-8aa4-1fea7547bc27 |

  Scenario:  Consult the list of countries
    When i send a get request to country/
    Then the system should return one json array with all the countries
    And the system response with "200"
