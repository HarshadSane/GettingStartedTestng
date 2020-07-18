package baseclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class UnitTestBaseClass {

	@BeforeMethod
	public void globalBeforeMethodSetup() {
		System.out.println("This is gloabl beforeMethod");
	}

	@BeforeSuite
	public void globalSetup() {
		System.out.println("Global setup");
	}

}
