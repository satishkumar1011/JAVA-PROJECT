package com.zensar.pageobjects;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.zensar.scriptutils.PageBase;
import com.zensar.scriptutils.ScenarioState;

public class SitaLandingPage extends PageBase {

	@FindBy(xpath = "//button[@type='button']")
	WebElement linkLogin;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement textEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement textPassword;

	@FindBy(xpath = "//button[@id='next']")
	WebElement buttonSubmit;
	
	@FindBy(xpath = "(//button[text()='Logout'])[1]")
	WebElement logoutButton;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement mobMyAccountDropDownButton;

	@FindBy(xpath = "(//button[text()='Logout'])[2]")
	WebElement mobLogoutButton;
	
	@FindBy(xpath = "//div [contains(@class,'circle')]")
	WebElement notification;
	
	@FindBy(xpath = "//button [contains(@class,'btn primary-btn-l-icon-text')]")
	WebElement clickSetupProject;
	
	@FindBy(xpath = "//h2 [contains(@class,'main-title')]")
	WebElement projectSetupPage;
	
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[1]")
	WebElement projectNumber;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[2]")
	WebElement clientName;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[3]")
	WebElement projectName;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[4]")
	WebElement projectPartner;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[5]")
	WebElement projectOwner;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[6]")
	WebElement startDate;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[7]")
	WebElement plannedEndDate;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[8]")
	WebElement country;
	
	@FindBy(xpath = "(//div [contains(@class,'col-12 tile-content')]//h6)[9]")
	WebElement industry;
	
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement projectDetailsNext;
	
	@FindBy(xpath = "//textarea [contains(@class,'overview-text ng-untouched ng-pristine ng-valid')]")
	WebElement projectOverview;
	
	
	@FindBy(xpath = "//kendo-icon[@class='k-i-calendar k-button-icon k-icon ng-star-inserted']")
	WebElement anticipateddate;
	
	@FindBy(xpath = "//div[@class='radio-options mr-b-24']//div[1]//input[1]")
	WebElement competitiveproject;
	
	@FindBy(xpath = "//span[contains(text(),'Access to additional resources/skills/expertise')]")
	WebElement primaryobjetivevalue;
	
	@FindBy(xpath = "//textarea [contains(@class,'overview-text ng-valid ng-dirty ng-touched')]")
	WebElement projectOverviewText;
	
	
	@FindBy(xpath = "//span[text()='3. Add client lead']")
	WebElement addClientLead;
	
	@FindBy(xpath = "//input[@aria-label='First Name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@aria-label='Email']")
	WebElement leadEmailId;
	
	
	@FindBy(xpath = "//button [contains(@class,'btn primary-btn-large')]")
	WebElement emailLeadConfirm;
	
	@FindBy(xpath = "//*[@class='charLimitNote']")
	WebElement projectOverviewNote;

	public SitaLandingPage(ScenarioState state) {
		super(state);
	}

	public void openSITA() {
		try {
			System.out.println("Entered try in open");
			String enviroment = getEnvironment();
			String url ;
			switch(enviroment){
			case "Staging":
				url= getEnvProperty("url_staging");
				break;
			case "Integration":
				url= getEnvProperty("url_integration");
				break;
			case "Production":
				url= getEnvProperty("url");
				break;
			default:
				url= getEnvProperty("url_integration");
				break;
			}
			getDriver().get(url);

		} catch (Exception e) {
			System.out.println("Entered Catch due to time out");
		}

	}
	
	public void loginToSITA() {
		pause(1000);
		loginToSITA(getEnvProperty("username"), getEnvProperty("password"));
	}
	
	public void loginToSITA(String username,String password) {
		embedScreenshot(linkLogin);
		forceClick(linkLogin,10);
		pause(500);
		System.out.println("Clicked Login");
		enterText(textEmail,username);
		System.out.println("username : " + username);
		enterText(textPassword, password);
		System.out.println("password : " + password);
		embedScreenshot(buttonSubmit);
		click(buttonSubmit);
		  long startTime=System.currentTimeMillis();
	        while(isPresent("//chr-modal-login")){    //Wait until login pop-up is disappeared
	            System.out.println("waiting for login popup to disapear...");
	            pause(500);
	            if((System.currentTimeMillis()-startTime) > 30000)    //break if taking too much time
	                break;

	        }
	

			if (isMobileBrowser()) {
				if (isPresent(mobMyAccountDropDownButton)) {
					click(mobMyAccountDropDownButton);
					pause(1000);
					if (isPresent(mobLogoutButton)) {
						System.out.println("Successfully Logged In Mobile!!!");
					}
					pause(1000);
				}
			} else {
				try {
					if (isPresent(logoutButton)) {
						System.out.println("Successfully Logged In Desktop -  logout button is present!!!");
					}
				} catch (WebDriverException e) {
					if (isVisibleInViewport(logoutButton)) {
						System.out.println("Successfully Logged In Desktop - -  logout button in viewport!!!");
					}
				}
				
				pause(1000);
			}
	}
	
	public void Notification()
	{
		waitForElement(notification);
		String notificationMessage = getText(notification);
		System.out.println("notification for Set up Project: " + notificationMessage);
		embedScreenshot();
		zAssertTrue(true, "Number of Set up Project notification =  " + notificationMessage,
				"There is no Set up Project notification  " + notificationMessage);
	}
	
	public void ClickSetUpProject() 
	{
		pause(4000);
		click(clickSetupProject);		
		embedScreenshot();
		pause(4000);
		waitForElement(projectSetupPage);
		highlightElement(projectSetupPage);
		embedScreenshot();
		zAssertTrue(isPresent(projectSetupPage), "redirected to Project setup page",
				"User not Redirected to project setup page");

	}
	
	
	public void ProjectDetails() 
	{
		waitForElement(projectNumber);
		String projectNumberValue = getText(projectNumber);
		System.out.println("notification for Set up Project: " + projectNumberValue);
		zAssertTrue(true, "Project Number for the Project =  " + projectNumberValue,
				"There is no Project Number for the Project  " + projectNumberValue);
		waitForElement(clientName);
		String clientNameValue = getText(clientName);
		System.out.println("notification for Set up Project: " + clientNameValue);
		zAssertTrue(true, "Client Name for the Project =  " + clientNameValue,
				"There is no Client Name for the Project  " + clientNameValue);
		waitForElement(projectName);
		String projectNameValue = getText(projectName);
		System.out.println("notification for Set up Project: " + projectNameValue);
		zAssertTrue(true, "Client Name for the Project =  " + projectNameValue,
				"There is no Client Name for the Project  " + projectNameValue);
		waitForElement(projectPartner);
		String projectPartnerValue = getText(projectPartner);
		System.out.println("notification for Set up Project: " + projectPartnerValue);
		zAssertTrue(true, "Client Name for the Project =  " + projectPartnerValue,
				"There is no Client Name for the Project  " + projectPartnerValue);
		waitForElement(projectOwner);
		String projectOwnerValue = getText(projectOwner);
		System.out.println("notification for Set up Project: " + projectOwnerValue);
		zAssertTrue(true, "Client Name for the Project =  " + projectOwnerValue,
				"There is no Client Name for the Project  " + projectOwnerValue);
		waitForElement(startDate);
		String startDateValue = getText(startDate);
		System.out.println("notification for Set up Project: " + startDateValue);
		zAssertTrue(true, "Client Name for the Project =  " + startDateValue,
				"There is no Client Name for the Project  " + startDateValue);
		waitForElement(plannedEndDate);
		String plannedEndDateValue = getText(plannedEndDate);
		System.out.println("notification for Set up Project: " + plannedEndDateValue);
		zAssertTrue(true, "Client Name for the Project =  " + plannedEndDateValue,
				"There is no Client Name for the Project  " + plannedEndDateValue);
		waitForElement(country);
		String countryValue = getText(country);
		System.out.println("notification for Set up Project: " + countryValue);
		zAssertTrue(true, "Client Name for the Project =  " + countryValue,
				"There is no Client Name for the Project  " + countryValue);
		waitForElement(industry);
		String industryValue = getText(industry);
		System.out.println("notification for Set up Project: " + industryValue);
		embedScreenshot();
		zAssertTrue(true, "Client Name for the Project =  " + industryValue,
				"There is no Client Name for the Project  " + industryValue);
		
		pause(4000);
		click(projectDetailsNext);
		embedScreenshot();		

	}
	
	public void projectOverview() {
		clearAndEnterText(projectOverview, getTestDataValue("ProjectOverviewdata"));
		click(projectOverviewNote);
		waitForElement(projectOverviewText);
		highlightElement(projectOverviewText);
		embedScreenshot();			
		zAssertTrue(isPresent(projectOverviewText), "redirected to project overview page",
				"User not Redirected to project overview page");
		
	}
	
	public void clientLead() {
		click(projectDetailsNext);
		waitForElement(addClientLead);
		highlightElement(addClientLead);
		embedScreenshot();	
		zAssertTrue(isPresent(addClientLead), "redirected to add client lead page",
				"User not Redirected to client lead page");
				
	}
	
	public void anticipated() {
		pause(4000);
		click(anticipateddate);
		zAssertTrue(isPresent(anticipateddate), "Anticipated date is selected",
				"Anticipated date is not selected");
		
				
	}
	
	public void competitive() {
		pause(2000);
		click(competitiveproject);
		embedScreenshot();	
		zAssertTrue(isPresent(competitiveproject), "Competitive Project is selected",
				"Competitive Project is not selected");
		
				
	}
	public void primaryobjetive() {
		pause(2000);
		click(primaryobjetivevalue);
		embedScreenshot();
		zAssertTrue(isPresent(primaryobjetivevalue), "Primary Objective value is selected",
				"Primary objective value is not selected");
		
				
	}
	public void firstLastName() 
	{
		clearAndEnterText(firstName, getTestDataValue("FirstName"));
		zAssertTrue(isPresent(firstName), "User entered first Name",
				"User has not entered first name");
		clearAndEnterText(lastName, getTestDataValue("LastName"));
		embedScreenshot();
		zAssertTrue(isPresent(firstName), "User entered last Name",
				"User has not entered last name");
		
	}
	public void leadEmail() 
	{
		clearAndEnterText(leadEmailId, getTestDataValue("LeadEmail"));
		zAssertTrue(isPresent(leadEmailId), "User entered Lead Email ID",
				"User has not entered Lead Email ID");
		click(projectDetailsNext);
		embedScreenshot();
		waitForElement(emailLeadConfirm);
		highlightElement(emailLeadConfirm);
		embedScreenshot();	
	}
	public void projectOverviewCharcterSet() {
		clearAndEnterText(projectOverview, getTestDataValue("ProjectOverviewdata"));
		click(projectOverviewNote);
		waitForElement(projectOverviewText);
		highlightElement(projectOverviewText);
		embedScreenshot();			
		zAssertTrue(isPresent(projectOverviewText), "redirected to project overview page",
				"User not Redirected to project overview page");
		
	}
}