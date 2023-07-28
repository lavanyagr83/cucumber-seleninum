package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("mobiletest")
	public void beforeValidation() {
		System.out.println("This will execute first");
	}
	
	@After("@mobiletest")
	public void afterValidation() {
		System.out.println("This will execute last");

	}
}
