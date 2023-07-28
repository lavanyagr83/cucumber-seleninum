package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	By topdeals = By.linkText("Top Deals");
	By Search = By.className("search-keyword");
	By ProductName = By.className("product-name");
	
	public void searchItem(String name) throws InterruptedException {
		driver.findElement(Search).sendKeys(name);
		Thread.sleep(2000);
	}
	public String productName() {
		return driver.findElement(By.className("product-name")).getText();
	}
	public void topDeals() {
		driver.findElement(topdeals).click();
	}
}
