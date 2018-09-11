Feature: create country
As a CRM administrator
  I want to create a country
  So i can

  Scenario Outline:  Create a new country
    Given I have access to the CRM service with write permissions
    When i send a post request with the "<country>" name and its´ "<key>"
    Then i should see the new "<country>" in the country list.
    Examples:
  | country   | key |
  | Venezuela | VE  |
  | Argentina | AR  |