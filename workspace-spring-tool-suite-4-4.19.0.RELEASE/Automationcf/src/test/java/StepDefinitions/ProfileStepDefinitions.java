package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjects.ProfilePage;
import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileStepDefinitions {
	private static final String DataTable = null;
	public WebDriver driver;
	TestContextSetup tcs;

	public ProfileStepDefinitions(TestContextSetup tcs) {
		this.tcs = tcs;
	}

	@Given("open the Chrome browser and goto the toucan website")
	public void open_the_chrome_browser_and_goto_the_toucan_website() throws InterruptedException {
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
		tcs.driver.get("https://ops.dev.toucanus.net/#/");

	}

	@Then("Login to the application")
	public void login_to_the_application(DataTable dataTable) throws InterruptedException {

		Thread.sleep(2000);
		ProfilePage profilepage = new ProfilePage(tcs.driver);

		List<List<String>> obj = dataTable.asLists(String.class);
		// profilepage.useridLogin().sendKeys(obj.get(0).get(0));
		tcs.driver.findElement(By.id("mat-input-0")).sendKeys(obj.get(0).get(0));
		// profilepage.passwordLogin();
		tcs.driver.findElement(By.id("mat-input-1")).sendKeys(obj.get(0).get(1));//
		Thread.sleep(2000);
		profilepage.Login();
		// tcs.driver.findElement(By.className("mdc-button__label")).click();//

	}

	@When("Go to the profile")
	public void go_to_the_profile() throws InterruptedException {
		Thread.sleep(2000);
		ProfilePage profilepage = new ProfilePage(tcs.driver);
		profilepage.txnLookup();
		profilepage.firstTxn();
		profilepage.merchantNoHeader();
		Thread.sleep(2000);
		profilepage.profileNameHeader();
		/*
		 * tcs.driver.findElement(By.id("txn")).click();
		 * tcs.driver.findElement(By.name("gotoInq_0")).click();
		 * tcs.driver.findElement(By.className("ActionBtn")).click();
		 * Thread.sleep(2000); tcs.driver.findElement(By.id("prof")).click();
		 */

	}

	@Then("Go to pricing")
	public void go_to_pricing() throws InterruptedException {
		ProfilePage profilepage = new ProfilePage(tcs.driver);
		Thread.sleep(2000);
		tcs.driver.switchTo().frame(0);
		profilepage.feesTab();
		// tcs.driver.findElement(By.cssSelector("div#mat-tab-label-0-1")).click();
		Thread.sleep(2000);
		profilepage.pricingLink();
		tcs.driver.findElement(By.linkText("Pricing")).click();
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

	}

}
