package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	public WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	By userid = By.id("mat-input-0");
	By password = By.id("mat-input-1");
	By loginbutton = By.className("mdc-button__label");
	By txnLookup = By.id("txn");
	By firstTxn = By.name("gotoInq_0");
	By merchantNoHeader = By.className("ActionBtn");
	By profileNameHeader = By.id("prof");
	By feesTab = By.cssSelector("div#mat-tab-label-0-1");
	By pricingLink = By.linkText("Pricing");

	public void useridLogin() throws InterruptedException {

		// return driver.findElement(userid);

	}

	public void passwordLogin() throws InterruptedException {

		driver.findElement(password);// id

	}

	public void Login() throws InterruptedException {

		driver.findElement(loginbutton).click();// classname
	}

	public void txnLookup() {
		driver.findElement(txnLookup).click();
	}

	public void firstTxn() {
		driver.findElement(By.name("gotoInq_0")).click();
	}

	public void merchantNoHeader() {
		driver.findElement(By.className("ActionBtn")).click();

	}

	public void profileNameHeader() {
		driver.findElement(By.id("prof")).click();
	}

	public void feesTab() {
		driver.findElement(By.cssSelector("div#mat-tab-label-0-1")).click();
	}

	public void pricingLink() {
		driver.findElement(By.linkText("Pricing")).click();
	}

}
