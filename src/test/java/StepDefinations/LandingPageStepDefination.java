package StepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefination {

	public LandingPage landingpage;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingpage = testContextSetup.pageObjectManager.getLandingPage();

	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {

		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^User serched with short name (.+) and extracted actual name of product$")
	public void user_serched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		landingpage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageproductName = landingpage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageproductName + " landing page");
	}
	
	 @And("^Added \"([^\"]*)\" items of the selected product to the cart$")
	    public void added_something_items_of_the_selected_product_to_the_cart(String quantity) throws Throwable 
	 {
		 landingpage.incrementQuantity(Integer.parseInt(quantity));
		 
	    }


}
