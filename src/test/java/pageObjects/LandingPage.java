package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By increment=   By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);

	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

}
