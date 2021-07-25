package com.greenkart.testCases;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.greenkart.base.TestBase;
import com.greenkart.pages.HomePage;
import com.greenkart.utils.Log;

public class HomePageTest extends TestBase {
	HomePage homepage;
	WebDriverWait wait;
	
	
public HomePageTest() {
	super();
}
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage=new HomePage();
		wait=new WebDriverWait(driver,10);
	}
	
	@Test(priority=1,enabled = false)
	public void verifyLogoOfHomePage() {
		Assert.assertTrue(homepage.verifyHomePageLogo());
		Log.info("Verifying HomePage Logo");//Verifying with the help of Asset Class
		
	}
	
	@Test(priority=0,enabled = false)
	public void verifyTitleOfPage() {
		Assert.assertEquals(homepage.getTitle(),"GreenKart - veg and fruits kart");
		Log.info("Verifying HomePage Title");
	}
	
	@Test(priority=2,enabled = false)
	public void VerifyTopDealsLink() {
		homepage.clickOnTopDeals();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(parentWindow);
		driver.close();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		Log.info("Verifying DealsPage launch and returning back to Homepage using window handles");
	}
	
	@Test(priority=3, enabled = false)
	public void VerifyFlightBookingLink() {
		homepage.clickOnflightBooking();
		driver.navigate().back();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String parentWindow=it.next();   
		String childWindow=it.next();
		driver.switchTo().window(parentWindow);
		driver.close();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		Log.info("Verifying flightsbooking launch and returning back to Homepage using window handles");
	}
	
	@Test(priority=4,enabled = true)
	public void verifyProductInCart() throws Exception {
		String itemsNeeded[]= {"Cucumber", "Mango", "Pears"};
		//itemsNeeded.
		int j=0;
		List<WebElement> products=driver.findElements(By.className("product-name"));
		for(int i=0;i<products.size();i++) {
			//System.out.println(products.get(i).getText());
			String[] product=products.get(i).getText().split("-");//to split into two string due to -
			String item=product[0].trim();// to remove the spaces present
			List<String> itemsNeededList=Arrays.asList(itemsNeeded);//To get contains method of arraylist
			if(itemsNeededList.contains(item)) {
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				
				j++;
				if(j==3) {
					break;
				}
				
			}
		}
		homepage.clickOnCartIcon();
		homepage.clickOnproceedToCheckoutbutton();
		homepage.enterpromocodeTextField();
		homepage.clickOnPromoApplyButton();
		wait.until(ExpectedConditions.visibilityOf(homepage.promoInfo));
		homepage.promoInfoIsDisplayed();
		homepage.clickOnPlaceOrderButton();
		Select s= new Select(homepage.selectTag);
		s.selectByValue("India");
		homepage.checkTermsAndConditions();
		homepage.clickOnProceedButton();
		Log.info("Verifying DealsPage launch and returning back to Homepage using window handles");
		
	
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
