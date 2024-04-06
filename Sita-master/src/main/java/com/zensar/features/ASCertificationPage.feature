
Feature:  ASCertificationPage
#Validate Airport Solutions enrolled users Landing Page CERTIFICATION

  Background: JWT token validation
    Given user validate JWT token

 Scenario Outline: Validate Airport Solutions enrolled users Landing Page CERTIFICATION tab REQUEST FOR CERTIFICATION button. #<DataSetName>

    Given user is subscribed to Airport Solutions
    When user open DigiHub Certification page
    And user click on click here button
    And user enter issues to Contact Certification Management Team
    Then user must successfully verify message
    
    Examples: 
      | DataSetName  |
      | Certification |
    