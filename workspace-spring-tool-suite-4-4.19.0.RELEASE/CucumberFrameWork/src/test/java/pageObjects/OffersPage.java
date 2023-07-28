package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");

	

	public void searchProduct() {
		driver.findElement(search).sendKeys("Tom");
	}

	public String getProductText() {
		return driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}

}
