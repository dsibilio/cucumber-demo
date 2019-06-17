Feature: Search by keyword 
As a product owner
I want the system to offer a search by keyword functionality
In order to make content easily accessible

  Scenario Outline: Getting expected results when searching by keyword
    Given the system is available
     When the user searches for the word "<keyword>"
     Then the results page should mention "<expected_result>"
  
    Examples: 
      | keyword        | expected_result | 
      | gherkin        | cucumber        | 
      | george martin  | game of thrones | 