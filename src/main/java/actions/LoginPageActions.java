package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;

import locators.LogInPageLocators;
import utility.BaseClass;
import utility.ConfigFileReader;
import utility.GenericMethods;

public class LoginPageActions extends BaseClass{

	int maxRetryCount = 5;
	ConfigFileReader configFileReader = new ConfigFileReader(); 
	LogInPageLocators loginpageLocators = new LogInPageLocators();
	
	public void enterUsername() throws InterruptedException {
		try {
		loginpageLocators.username.sendKeys(configFileReader.getUsername());
		}
		catch(ElementNotInteractableException e) {
			Thread.sleep(2000);
			loginpageLocators.username.sendKeys(configFileReader.getUsername());
		}
	}
	
	public void enterPassword() {
		loginpageLocators.password.sendKeys(configFileReader.getPassword());
	}
	
	public void clickLoginBtn() {
		loginpageLocators.submitBttn.click();
	}
			
	public void validateSAPHomepage() {
		
	}
	
	public void searchSpecificModule(String moduleName) throws InterruptedException {
		
		System.out.println(">>>>>>>>>>>>>>>>>>Starting import and Validation of new Module");
		System.out.println(">>>>>>> Status of validateImportedFileErrorFlag is " +ImportEmployeeDataPageActions.validateImportedFileErrorFlag);
		
		if(ImportEmployeeDataPageActions.validateImportedFileErrorFlag==true) {
			Assert.assertFalse(true, "Error present in previous steps...Exiting test execution");
		}
		loginpageLocators.searchBox.click();
		loginpageLocators.searchBox.sendKeys(moduleName);
		Thread.sleep(2000);
		try {
			GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0));

		}
		catch(Exception e) {
			GenericMethods.actionClassForClickOnElement(driver.findElements(By.xpath("//div[@class='sapMPopoverScroll']/ul")).get(0));

		}
	}
	
	
}
