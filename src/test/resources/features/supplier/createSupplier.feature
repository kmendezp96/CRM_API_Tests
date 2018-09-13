Feature: create supplier
  As a CRM administrator
  I want to create a supplier
  So i can have their information on the system
  Background:
    Given I have access to CRM "supplier" service with "write permission"

  Scenario Outline:  Create a new supplier
    When i send a post request to the service with the "<address>", "<city>", "<phoneNumber>", "<phoneNumberType>", "<email>", "<supplierName>", "<twitter>" and "<url>"
    Then i should be able to consult the new supplier by its' id
    And the system response with a "200" status code
    Examples:
  | address                  | city       | phoneNumber  | phoneNumberType | email            | supplierName | twitter    | url                       |
  | 1239  Kildeer Drive      | Portsmouth | 757-273-4910 | mobile          | sup1@gmail.com   | supplier1    | @supplier1 | https://www.supplier1.com |
  | 2734  Spring Haven Trail | Woodport   | 609-516-1691 | mobile          | sup2@gmail.com   | supplier2    | @supplier2 | https://www.supplier2.com |