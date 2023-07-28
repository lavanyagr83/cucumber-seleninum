import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Profile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ops.dev.toucanus.net/#");
		driver.findElement(By.cssSelector("input.mat-input-element")).sendKeys("lavanya");
		driver.findElement(By.id("mat-input-1")).sendKeys("Password@12");// id

		driver.findElement(By.className("mat-button-wrapper")).click();// classname

		// driver.findElement(By.cssSelector("mat-card#opsmenu_l0_0")).click();
		driver.findElement(By.id("txn")).click();
		driver.findElement(By.name("gotoInq_0")).click();
		driver.findElement(By.className("ActionBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("prof")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div#mat-tab-label-0-1")).click();
		// driver.findElement(By.cssSelector("div[aria-posinset='2']")).click();
		// driver.findElement(By.id("mat-tab-label-0-1")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Pricing")).click();
		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();
		int count = 0;
		for (String handle : windows) {
			count++;
			if (count == 1) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Risk")).click();
		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();
		int count = 0;
		for (String handle : windows) {
			count++;
			if (count == 1) {
				driver.switchTo().window(handle);
				break;
			}
		}
		driver.findElement(By.id("edit")).click();
	}

}
