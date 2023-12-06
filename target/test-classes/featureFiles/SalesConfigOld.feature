@SAPDemo
Feature: Demo SAP Sales Configuration module

	@CreditMemoReq
  Scenario Outline: Add Workflow for Credit Memo Req
    Given Launch SAP portal with url
    When  User enters the userid and password
    And   Clicks on submit button for login into portal
    Then  Validate the navigation to SAP homepage
    When  User clicks on Sales Configuration Tab
    Then  Validate Manage Sales Doc Workflows box is visible
    When  User clicks on Manage Sales Doc Workflows box
    Then  Validate Manage workflow section is launched
    When  User selects a "<module>" to add workflow from dropdown
    And   Clicks on Add button
    Then  Validate New Workflow creation page has launched
    When  User fills up all the required details "<newWorkflowName>","<description>","<validFrom>","<validTo>"  and  "<precondition>" 
    And   Clicks on save button
    Then  Validate the new workflow is created
    

    Examples: 
      | module | newWorkflowName | description | validFrom | validTo | preCondition |
      | Workflow for Credit Memo Req. (obsolete) | Test workflow 1 | New workflow creation | 10.11.2021 | 12.11.2021 | |
      
      
  @SalesOrders
  Scenario Outline: Add Workflow for Sales Orders
    When  User selects a "<module>" to add workflow from dropdown
    And   Clicks on Add button
    Then  Validate New Workflow creation page has launched
    When  User fills up all the required details "<newWorkflowName>","<description>","<validFrom>","<validTo>"  and  "<precondition>" 
    And   Clicks on save button
    Then  Validate the new workflow is created
    

    Examples: 
      | module | newWorkflowName | description | validFrom | validTo | preCondition |
      | Workflow for Sales Orders | Test workflow 2 | New workflow creation | 13.11.2021 | 15.11.2021 | | 
      
  @CreditMemoRequests
  Scenario Outline: Add Workflow for Credit Memo Requests
    When  User selects a "<module>" to add workflow from dropdown
    And   Clicks on Add button
    Then  Validate New Workflow creation page has launched
    When  User fills up all the required details "<newWorkflowName>","<description>","<validFrom>","<validTo>"  and  "<precondition>" 
    And   Clicks on save button
    Then  Validate the new workflow is created
    

    Examples: 
      | module | newWorkflowName | description | validFrom | validTo | preCondition |
      | Workflow for Credit Memo Requests | Test workflow 3 | New workflow creation | 16.11.2021 | 18.11.2021 | | 
      
  @SalesQuotations
  Scenario Outline: Add Workflow for Sales Quotations
    When  User selects a "<module>" to add workflow from dropdown
    And   Clicks on Add button
    Then  Validate New Workflow creation page has launched
    When  User fills up all the required details "<newWorkflowName>","<description>","<validFrom>","<validTo>"  and  "<precondition>" 
    And   Clicks on save button
    Then  Validate the new workflow is created
    

    Examples: 
      | module | newWorkflowName | description | validFrom | validTo | preCondition |
      | Workflow for Sales Quotations | Test workflow 4 | New workflow creation | 19.11.2021 | 21.11.2021 | | 
      