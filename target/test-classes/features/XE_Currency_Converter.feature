Feature: Verify currency convert functionality for Xe

  @xeConvertCurrency
  Scenario Outline: Currency Conversion check
    When user navigates to Xe currency convertor Home Page
    And user enters amount as '<AMOUNT>', from currency as '<FROM_CURRENCY>' and to currency as '<TO_CURRENCY>'
    Then user clicks on convert button
    And user verifies converted currency amount
    Then user closes the web browser
    
    Examples: 
      |AMOUNT | FROM_CURRENCY | TO_CURRENCY | 
      |50			| EUR          	| GBP        	|     
      |75			| EUR         	| GBP        	|     
      |23			| EUR          	| GBP        	|     
      |85			| EUR          	| GBP        	|     
      |194		| EUR          	| GBP        	|
      |580		| INR          	| GBP        	|
      |75			| EUR          	| USD        	|
