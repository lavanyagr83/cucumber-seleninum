import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Irctc {

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
        driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input.ng-tns-c57-8")).sendKeys("hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.className("heading-font")).click();
		//driver.findElement(By.cssSelector("input.ng-tns-c57-8")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input.ng-tns-c57-9")).sendKeys("Visakhapatnam");
		//driver.findElement(By.className("heading-font")).click();
		//driver.findElement(By.cssSelector("label[class*='heading-']")).click();//css selector using static word(regular expression)
		driver.findElement(By.xpath("//label[contains(@class,'heading-')]")).click();//xpath using static word(regular expression)
		driver.findElement(By.className("ng-tns-c65-12")).click();
		//driver.findElement(By.className("class=\"ui-dropdown-trigger ui-state-default ui-corner-right ng-tns-c65-12\"")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'12')]")).click();
		//driver.findElement(By.className("search_btn loginText ng-star-inserted")).click();
		//driver.findElement(By.xpath("//li/span[1]")).click();
		driver.findElement(By.cssSelector("li[aria-label='GENERAL']")).click();
				
		driver.findElement(By.id("970875")).click();
		
	}

}
