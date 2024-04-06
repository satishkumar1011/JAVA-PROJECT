Feature: ASSiteListPage

  #Airport Solutions SiteList Page for enrolled users
  Background: Sita DigiHub Application Login
    Given user launched the Sita DigiHub application
    When user enters the login credentials on Login Page
    Then user sees successful login

  Scenario Outline: Validate search functionality using the text with an existing details #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user able to validate functionality using the text with an existing details

    Examples: 
      | DataSetName |
      | SiteList    |
      
      Scenario Outline: Verify search functionality using the text with an existing details
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user search for details on Site List Page <searchdata>
    Examples:
      | searchdata                  |
      | JAI                         |
      | hussain.al-lawati@sita.aero |

  Scenario Outline: Validate search functionality using the text with an non existing details #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user able to validate functionality using the text with an non existing details

    Examples: 
      | DataSetName |
      | SiteList    |

  Scenario Outline: Validate user able to expand Row view in Site List #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user able to validate expand Row view in Site List

    Examples: 
      | DataSetName |
      | SiteList    |

  Scenario Outline: Validate user view all the columns available for display in the site list are shown #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user able to validate all the columns available for display in the site list are shown

    Examples: 
      | DataSetName |
      | SiteList    |

  Scenario Outline: Validate user able to deselect any column in Customize table if do not wish to view #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site List page
    Then user able to validate deselect any column in Customize table if do not wish to view

    Examples: 
      | DataSetName |
      | SiteList    |
