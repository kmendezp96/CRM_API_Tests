Feature: delete country
  As a CRM administrator
  I want to be able to delete a specific country
  So i can destroy the unnecessary countries

  Background:
    Given I have access to the CRM service with write permissions

  Scenario Outline:  delete a country
    When i send a delete request to country/"<id>" of an existent country
    And the system response with "200"
    Examples:
      | id                                   |
      | a0e54e87-033d-4748-a1eb-8aec301c653e |
