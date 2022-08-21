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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefination2 {
	
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public CheckoutPageStepDefination2(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getcheckoutPage();

	}

	@And("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		
    }
	
	 @Then("^User proceed to checkout and validate the (.+) items in check out page$")
	    public void user_proceed_to_checkout_and_validate_the_items_in_check_out_page(String name) throws Throwable {
	        checkoutPage.CheckoutItems();
	        //Thread.sleep(2000);
	    }

	

}
