package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PricingStepDefinitions {
	public WebDriver driver;
	TestContextSetup tcs;
	public PricingStepDefinitions(TestContextSetup tcs) {
		this.tcs = tcs;
	}
	
	

	@Then("Change MDR to {int}%")
	public void change_mdr_to(Integer int1) throws InterruptedException {
		Thread.sleep(2000);
		tcs.driver.switchTo().frame(0);
		Thread.sleep(2000);
		tcs.driver.findElement(By.id("edit")).click();

	}
}
