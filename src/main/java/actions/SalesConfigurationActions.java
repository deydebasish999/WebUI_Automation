package actions;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import locators.SalesConfigurationLocators;
import utility.BaseClass;
import utility.ConfigFileReader;
import utility.GenericMethods;

public class SalesConfigurationActions extends BaseClass{

	int maxRetryCount = 5;
	ConfigFileReader configFileReader = new ConfigFileReader(); 
	SalesConfigurationLocators salesConfigurationLocators = new SalesConfigurationLocators();
	
	public void enterUsername() {
		salesConfigurationLocators.username.sendKeys(configFileReader.getUsername());
	}
	
	public void enterPassword() {
		salesConfigurationLocators.password.sendKeys(configFileReader.getPassword());
	}
	
	public void clickLoginBtn() {
		salesConfigurationLocators.submitBttn.click();
	}
			
	public void validateSAPHomepage() {
		
	}
	
	public void clickSalesConfgurationTab() {
		try {
		GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.salesConfigurationTab.get(0));
		salesConfigurationLocators.salesConfigurationTab.get(0).click();
		}
		catch(Exception e) {
			//GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.salesConfigurationTab.get(0));
			for(int i= 0; i<maxRetryCount; i++) {
				if(salesConfigurationLocators.salesConfigurationTab.size()>0) {
					salesConfigurationLocators.salesConfigurationTab.get(i).click();
				}
			}
			
		}
		
	}
	
	public void validateManageSalesDocWorkflowsbox() {
		GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.manageSalesDocWorkflows);
		Assert.assertTrue(salesConfigurationLocators.manageSalesDocWorkflows.isDisplayed(),"Manage Sales Doc Workflows box is not visible");
	}
	
	public void clickManageSalesDocWorkflowsbox() {
		salesConfigurationLocators.manageSalesDocWorkflows.click();
	}
	
	public void validateManageWorkflowSection() {
		
	}
	
	public void modulSelectionToAddWorkflow(String module) {
		int counter=0;
		try {
			GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.workflowDropdownArrow);
			salesConfigurationLocators.preConditionDropdownArrow.click();

		}
		catch(Exception e) {
			salesConfigurationLocators.preConditionDropdownArrow.click();

		}
		for(int i=0;i<salesConfigurationLocators.workflowDropdownlist.size();i++) {
			if(salesConfigurationLocators.workflowDropdownlist.get(i).getText().contains(module)) {
				salesConfigurationLocators.workflowDropdownlist.get(i).click();
				counter++;
			}
				
		}
		if(counter==0)
			Assert.assertTrue(false,"The module name provided is not present");
	}
	
	public void clickAddWorkflowBttn() {
		salesConfigurationLocators.addWorkflowButton.click();
	}
	
	public void validateNewWorkflowCreationPage() {
		
	}
	
	public void fillNewWorkflowDetails(String newWorkflowName, String description, String validFrom, String validTo, String preCondition) {
		try {
			GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.newWorkflowName);

		}
		catch(StaleElementReferenceException e) {
			GenericMethods.explicitWaitByExpectedConditionVisibility(salesConfigurationLocators.newWorkflowName);

		}
		salesConfigurationLocators.newWorkflowName.clear();
		salesConfigurationLocators.newWorkflowName.sendKeys(newWorkflowName);
		salesConfigurationLocators.description.sendKeys(description);
		salesConfigurationLocators.inputdates.get(0).sendKeys(validFrom);
		salesConfigurationLocators.inputdates.get(1).sendKeys(validTo);

	}
	
	public void clickSaveBttn() {
		salesConfigurationLocators.backBtn.click();
		GenericMethods.acceptAlert();
	}
	
	
}
