Feature: update country
  As a CRM administrator
  I want to be able to change the attributes of a specific country
  So i will be able to update the information of that country

  Background:
    Given I have access to the CRM service with write permissions

  Scenario Outline:  update a country
    When i send a put request to country/"<id>" of an existent country with the updated fields "<text>" and "<key>"
    And the system response with "200"
    Examples:
      | id                                   | text   | key |
      | 4482305e-b2d2-420e-8cda-65131a42786a | Brazil | BR  |
      | 47ba827d-2e3c-420d-8aa4-1fea7547bc27 |        | NO  |

