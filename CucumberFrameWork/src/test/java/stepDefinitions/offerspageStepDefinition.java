package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.OffersPage;

@SuppressWarnings("deprecation")
public class offerspageStepDefinition {
	public WebDriver driver;
	String homePageProductName;
	String OffersPageProductName;
	TestContextSetup tcs;

	public offerspageStepDefinition(TestContextSetup tcs) {
		this.tcs = tcs;
	}

	@Then("user go and search with same short name in offers page if product exist")
	public void user_go_and_search_with_same_short_name_in_offers_page_if_product_exist() throws InterruptedException {
		OffersPage offersPage = new OffersPage(tcs.driver);
		HomePage homepage = new HomePage(tcs.driver);
		homepage.topDeals();
		
		// tcs.driver.findElement(By.linkText("Top Deals")).click();
		Thread.sleep(2000);

		Set<String> windows = tcs.driver.getWindowHandles();
		int count = 0;
		for (String handle : windows) {
			count++;
			if (count == 2) {
				tcs.driver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(2000);
		offersPage.searchProduct();

		// tcs.driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Tom");
		OffersPageProductName = offersPage.getProductText();
		System.out.println(OffersPageProductName + " " + "Extracted from the offers page");
	}

	@And("Verify the homePageProductName and OffersPageProductName are same")
	public void Match_product() {
		// Assert.assertEquals(homePageProductName, tcs.homePageProductName);
		System.out.println("Comparing " + OffersPageProductName + " and " + tcs.homePageProductName + " : "
				+ OffersPageProductName.equals(tcs.homePageProductName));
		// System.out.println(OffersPageProductName.equals(tcs.homePageProductName));
	}

}
