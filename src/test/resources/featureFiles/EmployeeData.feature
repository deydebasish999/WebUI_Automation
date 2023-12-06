@SAPDemoNew
Feature: Demo SAP Employee Data module

@Test1
  Scenario: Login to Successfactor UI
    Given Launch SAP portal with url
    When  User enters the userid and password
    And   Clicks on submit button for login into portal
    Then  Validate the navigation to SuccessFactor homepage
      
#@Test10
#  Scenario Outline: Validate the Templates for any errors 
#    When  User search for specific module "<moduleName>" and navigates to the module
#    Then  Validate user navigated to the module
#    When  User clicks search for an entity to import data "<entityName>"
#    And   User clicks on browse button to upload the file "<fileName>"
#    Then  Validate the correct validation message for "<fileName>"
      
#       Examples:
#      |moduleName| entityName | fileName |
#      |Import Employee Data|Employment Details|EmploymentInfo|
#      |Import Employee Data | Basic Import | BasicUserInfo |
      

	@Test2
  Scenario Outline: Import and Validate BasicUserInfoImportTemplate
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for BasicImport

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Basic Import | BasicUserInfo |
      
      
	@Test3
  Scenario Outline: Import and Validate Biographical Info Template
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for BiographicalInfo

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Biographical Information | PersonInfo |
      
	@Test4
  Scenario Outline: Import and Validate Employment info Template
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for EmploymentInfo

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Employment Details | EmploymentInfo |        
      
	@Test5
  Scenario Outline: Import and Validate Job History Template
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for JobInfo

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Job History | JobInfo |      
      
	@Test6
  Scenario Outline: Import and Validate PersonalInfo Template
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for PersonalInfo

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Personal Information | PersonalInfo |  
      
	@Test7
  Scenario Outline: Import and Validate Compensation Template
    When  User search for specific module "<moduleName>" and navigates to the module
    Then  Validate user navigated to the module
    When  User clicks search for an entity to import data "<entityName>" for importing
    And   User clicks on browse button to upload the file "<fileName>" for importing
    Then  Validate the correct validation message for "<fileName>"
    And   User click on import button
    Then  Validate import successful message
    And   User searches for the imported employee and validates all the required details for CompensationlInfo

    Examples:
      |moduleName| entityName | fileName |
      |Import Employee Data| Compensation Information | CompInfo |
          
