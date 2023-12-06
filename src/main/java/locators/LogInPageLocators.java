package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class LogInPageLocators {

	@FindBy(how= How.ID, using="j_username")
	public WebElement username;
	
	@FindBy(how= How.ID, using="j_password")
	public WebElement password;
	
	@FindBy(how= How.ID, using="logOnFormSubmit")
	public WebElement submitBttn;
	
	@FindBy(how= How.XPATH, using="//*[@id='bizXSearchField-I']")
	public WebElement searchBox;
	
	public LogInPageLocators() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
}
