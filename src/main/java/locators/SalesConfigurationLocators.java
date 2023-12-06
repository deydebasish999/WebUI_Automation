package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class SalesConfigurationLocators {

	@FindBy(how= How.ID, using="USERNAME_FIELD-inner")
	public WebElement username;
	
	@FindBy(how= How.ID, using="PASSWORD_FIELD-inner")
	public WebElement password;
	
	@FindBy(how= How.ID, using="LOGIN_LINK")
	public WebElement submitBttn;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUshellAnchorItemInner'][text()='Sales Configuration']")
	public List<WebElement> salesConfigurationTab;
	
	@FindBy(how= How.XPATH, using="//span[@class='sapMTextMaxLine sapMTextLineClamp'][contains(text(),'Man­age Sales Doc­u­ment Work­flows')]")
	public WebElement manageSalesDocWorkflows;
	
	@FindBy(how= How.XPATH, using= "//*[@class='sapMSltArrow']")
	public WebElement workflowDropdownArrow;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUiSimpleFixFlexFlexContent']/ul/li")
	public List<WebElement> workflowDropdownlist;
	
	@FindBy(how= How.XPATH, using="//*[text()='Add']")
	public WebElement addWorkflowButton;
	
	@FindBy(how= How.XPATH, using="//input[@type='text'][@class='sapMInputBaseInner']")
	public WebElement newWorkflowName;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapMInputBaseInner sapMTextAreaInner']")
	public WebElement description;
	
	@FindBy(how= How.XPATH, using="//input[@placeholder='dd.MM.yyyy'][@class='sapMInputBaseInner']")
	public List<WebElement> inputdates;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapMSltLabel']")
	public WebElement preConditionDropdownArrow;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUiSimpleFixFlexFlexContent']/ul/li")
	public WebElement preConditionDropdownList;
	
	@FindBy(how= How.XPATH, using= "//a[@id='backBtn']/span[@class='sapUshellShellHeadItmCntnt']")
	public WebElement backBtn;
	
	
	public SalesConfigurationLocators() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
}
