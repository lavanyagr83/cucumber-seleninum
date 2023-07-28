package stepDefinitions;

import java.time.Duration;
import java.util.*;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;

public class homepageStepDefinition {
	public WebDriver driver;
	String homePageProductName;
	String OffersPageProductName;
	TestContextSetup tcs;

	public homepageStepDefinition(TestContextSetup tcs) {
		this.tcs = tcs;
	}

	@Given("User is on GreenCart  Landing Page")
	public void user_is_on_green_cart_landing_page() throws InterruptedException {
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		options.addArguments("--disable-notifications");

		tcs.driver = new ChromeDriver(options);
		tcs.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		tcs.driver.manage().window().maximize();
		tcs.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("user searched with short name {string} and extract actual product")

	public void user_searched_with_short_name_and_extract_actual_product(String shortName) throws InterruptedException {

		HomePage homepage = new HomePage(tcs.driver);
		homepage.searchItem(shortName);
		// tcs.driver.findElement(By.className("search-keyword")).sendKeys(shortName);
		Thread.sleep(2000);
		tcs.homePageProductName = homepage.productName().split("-")[0].trim();
		// tcs.homePageProductName=tcs.driver.findElement(By.className("product-name")).getText().split("-")[0].trim();
		System.out.println(tcs.homePageProductName + " " + "Extracted from the home page");

	}

}
