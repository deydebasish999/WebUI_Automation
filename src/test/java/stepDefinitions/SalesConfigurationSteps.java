package stepDefinitions;

import actions.SalesConfigurationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseClass;
import utility.ConfigFileReader;

@SuppressWarnings("unused")
public class SalesConfigurationSteps extends BaseClass{

	ConfigFileReader configFileReader = new ConfigFileReader();
	SalesConfigurationActions salesConfigurationActions = new SalesConfigurationActions();
	
//	@Given("Launch SAP portal with url")
//	public void launch_sap_portal_with_url() {
//	    
//		driver.get(configFileReader.getEnvironmentUrl());
//	}
//
//	@When("User enters the userid and password")
//	public void user_enters_the_userid_and_password() {
//		salesConfigurationActions.enterUsername();
//		salesConfigurationActions.enterPassword();
//	}
//
//	@When("Clicks on submit button for login into portal")
//	public void clicks_on_submit_button_for_login_into_portal() {
//		salesConfigurationActions.clickLoginBtn();
//		
//	}
//
//	@Then("Validate the navigation to SAP homepage")
//	public void validate_the_navigation_to_sap_homepage() {
//		
//
//	}
//
//	@When("User clicks on Sales Configuration Tab")
//	public void user_clicks_on_sales_configuration_tab() {
//	    
//		salesConfigurationActions.clickSalesConfgurationTab();
//	}
//
//	@Then("Validate Manage Sales Doc Workflows box is visible")
//	public void validate_manage_sales_doc_workflows_box_is_visible() {
//	    
//		salesConfigurationActions.validateManageSalesDocWorkflowsbox();
//	}
//
//	@When("User clicks on Manage Sales Doc Workflows box")
//	public void user_clicks_on_manage_sales_doc_workflows_box() {
//	    
//		salesConfigurationActions.clickManageSalesDocWorkflowsbox();
//	}
//
//	@Then("Validate Manage workflow section is launched")
//	public void validate_manage_workflow_section_is_launched() {
//	    
//		salesConfigurationActions.validateManageWorkflowSection();
//	}
//
//	@When("User selects a {string} to add workflow from dropdown")
//	public void user_selects_a_to_add_workflow_from_dropdown(String module) {
//		salesConfigurationActions.modulSelectionToAddWorkflow(module);
//
//	}
//
//	@When("Clicks on Add button")
//	public void clicks_on_add_button() {
//	    
//		salesConfigurationActions.clickAddWorkflowBttn();
//	}
//
//	@Then("Validate New Workflow creation page has launched")
//	public void validate_new_workflow_creation_page_has_launched() {
//		salesConfigurationActions.validateNewWorkflowCreationPage();
//
//	}
//
//	@When("User fills up all the required details {string},{string},{string},{string}  and  {string}")
//	public void user_fills_up_all_the_required_details_and(String newWorkflowName, String description, String validFrom, String validTo, String preCondition) {
//	    
//		salesConfigurationActions.fillNewWorkflowDetails(newWorkflowName, description, validFrom, validTo, preCondition);
//	}
//
//	@When("Clicks on save button")
//	public void clicks_on_save_button() {
//	    salesConfigurationActions.clickSaveBttn();
//
//	}
//
//	@Then("Validate the new workflow is created")
//	public void validate_the_new_workflow_is_created() {
//	    
//
//	}

}
