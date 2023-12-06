package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class EmployeeProfilePageLocators {

	@FindBy(how= How.ID, using="__xmlview0--selectType-arrow")
	public WebElement entitySearchDrpDownButton;

	
	@FindBy(how= How.XPATH, using="//div[@id='__picker1-fullName']")
	public List<WebElement> fullName;
	
	@FindBy(how= How.XPATH, using="//*[@id='__picker1-fullName']/span")
	public WebElement userName;
	
	@FindBy(how= How.XPATH, using="//*[@id='__xmlview0--title']")
	public WebElement title;
	
	@FindBy(how= How.XPATH, using="//*[@id='__xmlview0--departmentDivision']")
	public WebElement departmentAndDivision;
	
	@FindBy(how= How.XPATH, using="//*[@id='__xmlview0--locationTimezone']")
	public WebElement location;
	
	@FindBy(how= How.XPATH, using="//div[@class='sapMPopoverScroll']/ul/li")
	public List<WebElement> employeeSearchList;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Person ID']/following-sibling::td/span")
	public WebElement personId;
	
	//Biographical locators
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Date of Birth']/following-sibling::td/span")
	public WebElement dateOfBirth;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Country of Birth']/following-sibling::td/span")
	public WebElement countryOfBirth;
	
	//Employment details locators
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUxAPObjectPageSubSectionHeaderTitle'][text()='Employment Details']")
	public WebElement employmentDetailsSection;
	
	@FindBy(how= How.XPATH, using="//*[@id='__button68-BDI-content'][text()='Employment']//parent::span//parent::span//parent::button//following-sibling::button")
	public WebElement employmentDetailsDrpDwnMenu;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='First Date Worked']//parent::tr//parent::tbody//parent::table//parent::td//parent::tr//parent::tbody//parent::table//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//following::div[@class='sapUxAPSubSectionSeeMoreContainer']//button/span")
	public List<WebElement> showMoreBttnEmpDetails;
	
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Recruit Date']/following-sibling::td/span")
	public WebElement recruitDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='First Date Worked']/following-sibling::td/span")
	public WebElement firstDateWorked;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Original Start Date']/following-sibling::td/span")
	public WebElement originalStartDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Seniority Start Date']/following-sibling::td/span")
	public WebElement seniorityStartDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Benefits Eligibility Start Date']/following-sibling::td/span")
	public WebElement benefitsEligibilityStartDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Previous Employment ID']/following-sibling::td/span")
	public WebElement previousEmploymentID;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Eligible for Stock']/following-sibling::td/span")
	public WebElement eligibleForStock;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Initial Stock Grant']/following-sibling::td/span")
	public WebElement initialStockGrant;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Professional Service Date']/following-sibling::td/span")
	public WebElement professionalServiceDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Initial Option Grant']/following-sibling::td/span")
	public WebElement initialOptionGrant;
	
	@FindBy(how= How.XPATH, using="//*[contains(@data-help-id,'First Employment')]/following-sibling::td/span")
	public WebElement employeesFirstEmployment;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Service Date']/following-sibling::td/span")
	public WebElement serviceDate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Contingent Worker']/following-sibling::td/span")
	public WebElement contingentWorker;
	
	//JobInfo Locators(Organization Info )
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUxAPObjectPageSubSectionHeaderTitle'][text()='Organisational Information']")
	public WebElement organizationalInfoSection;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Company']//parent::tr//parent::tbody//parent::table//parent::td//parent::tr//parent::tbody//parent::table//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//following::div[@class='sapUxAPSubSectionSeeMoreContainer']//button/span")
	public List<WebElement> showMoreBttnOrganizationalInfoSection;
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUxAPObjectPageSubSectionHeaderTitle'][text()='Job Information']")
	public WebElement jobInfoSection;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Job Classification']//parent::tr//parent::tbody//parent::table//parent::td//parent::tr//parent::tbody//parent::table//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//following::div[@class='sapUxAPSubSectionSeeMoreContainer']//button/span")
	public List<WebElement> showMoreBttnJobInfoSection;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Company']/following-sibling::td/span")
	public WebElement company;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Estate']/following-sibling::td/span")
	public WebElement Estate;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Job Classification']/following-sibling::td/span")
	public WebElement JobClassification;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Job Title']/following-sibling::td/span")
	public WebElement JobTitle;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Location']/following-sibling::td/span")
	public WebElement Location;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Position']/following-sibling::td/span")
	public WebElement Position;
	
	//@FindBy(how= How.XPATH, using="//*[@data-help-id='Supervisor']/following-sibling::td/span")
	//public WebElement Supervisor;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Contract Type']/following-sibling::td/span")
	public WebElement ContractType;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Time Zone']/following-sibling::td/span")
	public WebElement TimeZone;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Employee Class']/following-sibling::td/span")
	public WebElement EmployeeClass;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Employment Type']/following-sibling::td/span")
	public WebElement EmploymentType;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='FTE']/following-sibling::td/span")
	public WebElement FTE;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Is Full Time Employee']/following-sibling::td/span")
	public WebElement IsFullTimeEmployee;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Line of Business - Centre']/following-sibling::td/span")
	public WebElement LineofBusinessCentre;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Group']/following-sibling::td/span")
	public WebElement Group;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Notes']/following-sibling::td/span")
	public WebElement Notes;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Pay Grade']/following-sibling::td/span")
	public WebElement PayGrade;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Pay Scale Type']/following-sibling::td/span")
	public WebElement PayScaleType;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Pay Scale Area']/following-sibling::td/span")
	public WebElement PayScaleArea;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Pay Scale Group']/following-sibling::td/span")
	public WebElement PayScaleGroup;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Pay Scale Level']/following-sibling::td/span")
	public WebElement PayScaleLevel;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Process']/following-sibling::td/span")
	public WebElement Process;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Regular/Temporary']/following-sibling::td/span")
	public WebElement RegularTemporary;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Standard Weekly Hours']/following-sibling::td/span")
	public WebElement StandardWeeklyHours;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Vertical']/following-sibling::td/span")
	public WebElement Vertical;
		
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Working Days per Week']/following-sibling::td/span")
	public WebElement WorkingDaysPerWeek;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Cost Centre']/following-sibling::td/span")
	public WebElement CostCentre;
	
	//Personal Info
	
	@FindBy(how= How.XPATH, using="//*[@class='sapUxAPObjectPageSubSectionHeaderTitle'][text()='Personal Information']")
	public WebElement personalInfoSection;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='First Name']/following-sibling::td/span")
	public WebElement FirstName;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Last Name']/following-sibling::td/span")
	public WebElement LastName;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Middle Name']/following-sibling::td/span")
	public WebElement MiddleName;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Salutation']/following-sibling::td/span")
	public WebElement Salutation;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Preferred Name']/following-sibling::td/span")
	public WebElement PreferredName;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Gender']/following-sibling::td/span")
	public WebElement Gender;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Marital Status']/following-sibling::td/span")
	public WebElement MaritalStatus;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Nationality']/following-sibling::td/span")
	public WebElement Nationality;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Native Preferred Language']/following-sibling::td/span")
	public WebElement NativePreferredLanguage;
	
	@FindBy(how= How.XPATH, using="//*[@data-help-id='Attachment']/following-sibling::td/span")
	public WebElement Attachment;
	
	@FindBy(how= How.XPATH, using="//span[@class='sapMBtnContent']//*[text()='Show']")
	public WebElement GenderShowBttn;
	
	@FindBy(how= How.NAME, using="q")
	public WebElement googleSearch;
	
	public EmployeeProfilePageLocators() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
}
