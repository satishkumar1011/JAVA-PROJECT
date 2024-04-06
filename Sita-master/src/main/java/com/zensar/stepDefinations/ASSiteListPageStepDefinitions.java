package com.zensar.stepDefinations;

import com.zensar.pageobjects.SitaLandingPage;
import com.zensar.scriptutils.ScenarioState;
import com.zensar.scriptutils.StepBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ASSiteListPageStepDefinitions extends StepBase {

	
	SitaLandingPage sitaLandingPage;
	

	public ASSiteListPageStepDefinitions(ScenarioState scenarioState) {
		super(scenarioState);
		
		sitaLandingPage = new SitaLandingPage(getState());
		
	}
	@Given("^user launched the Sita DigiHub application$")
	public void user_navigates_to_Isg_Landing_Page() throws Throwable {
		sitaLandingPage.openSITA();
		
	}
	
	@When("^user enters the login credentials on Login Page$")
	public void user_clicks_on_submit_another_item() throws Throwable {
		sitaLandingPage.loginToSITA();
	}
	@Then("^user sees successful login$")
	public void verify_for_Notifications() throws Throwable {
		sitaLandingPage.Notification();
	}
	
	
    @When("^user clicks on Airport Solutions Subscriptions$")
	public void user_clicks_on_set_up_Project_icon() throws Throwable {
    	sitaLandingPage.ClickSetUpProject();
		
	}
    @And("^user click on Airport Solutions Subscriptions Site List page$")
	public void user_verifies_project_details_click_next() throws Throwable {
    	sitaLandingPage.ProjectDetails();
	}
    @Then("^user able to validate functionality using the text with an existing details$")
	public void navigate_Project_Overview_section_add_project_overview() throws Throwable {
    	sitaLandingPage.projectOverview();
	}
    
    
	}
