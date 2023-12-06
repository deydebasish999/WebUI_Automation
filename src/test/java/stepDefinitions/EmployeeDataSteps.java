package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import actions.EmployeeProfilePageActions;
import actions.ImportEmployeeDataPageActions;
import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseClass;
import utility.ConfigFileReader;
import utility.GenericMethods;


public class EmployeeDataSteps extends BaseClass{

	ConfigFileReader configFileReader = new ConfigFileReader();
	LoginPageActions loginPageActions = new LoginPageActions();
	ImportEmployeeDataPageActions importEmployeeDataActions = new ImportEmployeeDataPageActions();
	EmployeeProfilePageActions employeeProfilePageActions= new EmployeeProfilePageActions();

	//Test 1 steps
	@Given("Launch SAP portal with url")
	public void launch_sap_portal_with_url() {
	    
		driver.get(configFileReader.getEnvironmentUrl());
	}

	@When("User enters the userid and password")
	public void user_enters_the_userid_and_password() throws Exception {
		
		loginPageActions.enterUsername();
		loginPageActions.enterPassword();
	}

	@When("Clicks on submit button for login into portal")
	public void clicks_on_submit_button_for_login_into_portal() {
		loginPageActions.clickLoginBtn();
		
	}

	@Then("Validate the navigation to SuccessFactor homepage")
	public void validate_the_navigation_to_sap_homepage() throws InterruptedException {
		
		Assert.assertEquals("SuccessFactors: Admin Centre",GenericMethods.getPageTitle(), "Succes Factor homepage could not be loaded");
		
	}

	//Steps for Test2
	
	@When("User search for specific module {string} and navigates to the module")
	public void user_search_for_specific_module_and_navigates_to_the_module(String moduleName) throws InterruptedException {
		loginPageActions.searchSpecificModule(moduleName);
	}

	@Then("Validate user navigated to the module")
	public void validate_user_navigated_to_the_module() {

	}
	
	@Then("User clicks search for an entity to import data {string} for importing")
	public void user_clicks_search_for_an_entity_to_import_data_for_importing(String entityName) throws InterruptedException {
		importEmployeeDataActions.searchEntityForImporting(entityName);
	}
	
	
	//@Then("User clicks search for an entity to import data {string}")
	//public void user_clicks_search_for_an_entity_to_import_data(String entityName) throws InterruptedException {
	//	importEmployeeDataActions.searchEntitye(entityName);
	//}

	//@Then("User clicks on browse button to upload the file {string}")
	//public void user_clicks_on_browse_button_to_upload_the_file(String fileName) throws InterruptedException, Exception {
	//	importEmployeeDataActions.chooseFileToUpload(fileName);
				
	//}
	
	@When("User clicks on browse button to upload the file {string} for importing")
	public void user_clicks_on_browse_button_to_upload_the_file_for_importing(String fileName) throws InterruptedException, IOException, AWTException {
		importEmployeeDataActions.chooseFileToUpload(fileName);
	}

	
	@Then("Validate the correct validation message for {string}")
	public void validate_the_correct_validation_message_for(String fileName) {
		
		importEmployeeDataActions.validateImportedFile(fileName);
	}

	
	@When("User click on import button")
	public void user_click_on_import_button() throws InterruptedException {
		importEmployeeDataActions.clickOnImportFile();
		
	}

	@Then("Validate import successful message")
	public void validate_import_successful_message() {
	 
	}


	@Then("User searches for the imported employee and validates all the required details for BasicImport")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_BasicImport() {
		try {
			employeeProfilePageActions.validateEmployeeProfileDataforBasicImport();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("User searches for the imported employee and validates all the required details for BiographicalInfo")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_BiographicalInfo() {
		try {
			employeeProfilePageActions.validateEmployeeProfileDataforBiographicalInfo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User searches for the imported employee and validates all the required details for EmploymentInfo")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_EmploymentInfo() {
		try {
			employeeProfilePageActions.validateEmployeeProfileDataforEmployementInfo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("User searches for the imported employee and validates all the required details for JobInfo")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_JobInfo() {
		try {
			employeeProfilePageActions.validateEmployeeProfileDataforJobHistory();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("User searches for the imported employee and validates all the required details for PersonalInfo")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_PersonalInfo() {
		try {
			employeeProfilePageActions.validateEmployeeProfileDataforPersonalInfo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("User searches for the imported employee and validates all the required details for CompensationlInfo")
	public void user_searches_for_the_imported_employee_and_validates_all_the_required_details_for_CompensationlInfo() {
//		try {
//			employeeProfilePageActions.validateEmployeeProfileDataforBasicImport();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	}
