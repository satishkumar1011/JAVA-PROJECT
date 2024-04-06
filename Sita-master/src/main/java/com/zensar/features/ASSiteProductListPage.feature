Feature: ASSiteProductListPage
#Airport Solutions Site Product List Page for enrolled users


  Scenario Outline: Validate search functionality using the text with an existing details #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site Product List page
    Then user able to validate functionality using the text with an existing details in Site Product List 
    
    Examples: 
      | DataSetName  |
      | ProductList |

  Scenario Outline:  Validate search functionality using the text with an non existing details #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site Product List page
    Then user able to validate functionality using the text with an non existing details in Site Product List
    
    Examples: 
      | DataSetName  |
      | ProductList |

  Scenario Outline: Validate user view all the columns available for display in the site Product list are shown #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site Product List page
    Then user able to validate all the columns available for display in the site list are shown in Site Product List
    
    Examples: 
      | DataSetName  |
      | ProductList |

  Scenario Outline: Validate user able to deselect any column in Customize table if do not wish to view #<DataSetName>
    When user clicks on Airport Solutions Subscriptions
    And user click on Airport Solutions Subscriptions Site Product List page
    Then user able to validate deselect any column in Customize table if do not wish to view in Site Product List
    
    Examples: 
      | DataSetName  |
      | ProductList |