import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selfirst {
WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        DesiredCapabilities cp = new DesiredCapabilities();
	        cp.setCapability(ChromeOptions.CAPABILITY, options);
	        options.merge(cp);
	        WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://unittest.dev.toucanus.net/#/");
	        System.out.println(driver.getTitle());//getting title
	        System.out.println(driver.getCurrentUrl());//getting url
	        //driver.close();//for closing browser
	        //driver.quit();//for closing all associated windows
	       // driver.findElement(By.id("mat-input-0")).sendKeys("lavany");//id
	        //driver.findElement(By.cssSelector("input#mat-input-0")).sendKeys("lavany");//id
	       // driver.findElement(By.cssSelector("input[id='mat-input-0']")).sendKeys("lav");//id
	        //driver.findElement(By.cssSelector("[name='f1']")).sendKeys("lav");//name
	        //driver.findElement(By.className("mat-input-element")).sendKeys("lav");//classname
	      driver.findElement(By.cssSelector("input.mat-input-element")).sendKeys("lavanya");//class name(tag.classname)

	        driver.findElement(By.id("mat-input-1")).sendKeys("Password@12");//id
	        //driver.findElement(By.linkText("FORGOT PASSWORD")).click();link text
	      
	       driver.findElement(By.className("mat-button-wrapper")).click();//classname
	       // System.out.println(driver.findElement(By.cssSelector("span.hint-msg")).getText());//getting error msg into the console
	        
	      
	        driver.findElement(By.cssSelector("mat-card#opsmenu_l0_0")).click();
	        
	        
	}

}
