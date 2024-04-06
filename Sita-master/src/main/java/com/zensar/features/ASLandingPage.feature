
Feature: ASLandingPage
#Airport Solutions Home Page for enrolled users

 Background: JWT token validation
  Given user validate JWT token

    Scenario Outline:  Validate Airport Solutions enrolled users Landing Page Navigation Tab - Home #<DataSetName>
    When  user is subscribed to Airport Solutions
    And user click on Airport Solutions Subscriptions HOME
    Then user able to see Landing Page Navigation HOME Tab
    
    Examples: 
      | DataSetName  |
      | Landing |
