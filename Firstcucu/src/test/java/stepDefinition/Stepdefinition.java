package stepDefinition;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Stepdefinition{
	WebDriver driver;

	
	@Given("user is on landing page")
	public void user_is_on_landing_page() {
	    System.out.println("First Step");

	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.manage().window().maximize();
        driver.get("https://ops.dev.toucanus.net/#/search/merchant");
	}

	@When("user login into the application with username and password")
	public void user_login_into_the_application_with_username_and_password() {
	   System.out.println("Second Step") ;
	}

	@Then("Home page is populated")
	public void home_page_is_populated() {
		   System.out.println("Third Step") ;

	}

	@Then("cards are displayed")
	public void cards_are_displayed() {
		   System.out.println("Fourth Step") ;

	    
	}

		
	
}
