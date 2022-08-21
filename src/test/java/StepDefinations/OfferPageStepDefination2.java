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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination2 {

	
	PageObjectManager pageObjectManager;
	TestContextSetup testContextSetup;

	public OfferPageStepDefination2(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	

	@Then("^User searched for (.+) same short name in offers page if product exist$")
	public void user_searched_for_same_short_name_in_offers_page_if_product_exist(String name) throws InterruptedException {
	
		
		switchToOffersPage();
		OffersPage offerspage = testContextSetup.pageObjectManager.getOffersPage();
		offerspage.searchItem(name);
		Thread.sleep(2000);
		testContextSetup.offerPageProducName = offerspage.getProductName();
        System.out.println(testContextSetup.offerPageProducName+" product page");
	}
	
	public void switchToOffersPage()
	{
		OffersPage offerspage = testContextSetup.pageObjectManager.getOffersPage();
		offerspage.selectTopDeals();
		testContextSetup.genericUtils.switchWindowToChild();
	}

    @And("^Validate product namein offers matches with landing page$")
    public void validate_product_namein_offers_matches_with_landing_page() throws Throwable {
        
    	Assert.assertEquals(testContextSetup.landingPageproductName, testContextSetup.offerPageProducName);
    	
    }

}
