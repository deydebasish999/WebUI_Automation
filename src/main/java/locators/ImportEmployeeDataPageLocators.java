package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class ImportEmployeeDataPageLocators {

	@FindBy(how= How.ID, using="__xmlview0--selectType-arrow")
	public WebElement entitySearchDrpDownButton;

	
	@FindBy(how= How.XPATH, using="//*[@class='sapMSLIDiv']/div")
	public List<WebElement> entitySearchBoxList;
	
	//*[@class='sapUiFupGroup']//div//div[@id='__xmlview0--fileUploader-fu_input']//div[@class='sapMInputBaseContentWrapper']
	@FindBy(how= How.XPATH, using="//*[@class='sapUiFupGroup']//div//div/following-sibling::div/child::button")
	public WebElement broweseBttn;
	
	
	
	@FindBy(how= How.XPATH, using="//*[@class='sapMBtnContent']/bdi[text()='Validate Import File Data']")
	public WebElement validateImportfileBttn;
	
	@FindBy(how= How.XPATH, using="//div[@class='sapMMsgStripMessage']/span")
	public WebElement validationMessage;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapMBtnContent']/bdi[text()='Import']")
	public WebElement importBttn;
	
	
	
	public ImportEmployeeDataPageLocators() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
}
