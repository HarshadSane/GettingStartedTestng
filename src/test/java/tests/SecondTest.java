package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.DuplicateUserException;
import app.ManageUser;
import baseclasses.UnitTestBaseClass;

public class SecondTest extends UnitTestBaseClass {

	private ManageUser mu;

	@Test(description = "Verify that getUser method retrieves the correct user")
	public void getExistingUserReturnsExistingSavedUser() throws DuplicateUserException {

		mu.addUser("abc@gmail.com");

		final String user = mu.getUser("abc@gmail.com");

		Assert.assertEquals(user, "abc@gmail.com");
	}

	@Test(description = "Verify that getUser method returns null")
	public void getNonExistingUserReturnsNull() {

		final String user = mu.getUser("abc@gmail.com");

		Assert.assertNull(user);
	}

	@BeforeMethod
	public void localSetup(Method testMethod) {
		final String desc = testMethod.getAnnotation(Test.class).description();
		System.out.println("Starting test :" + testMethod.getName() + " description : " + desc);
		mu = new ManageUser();
	}

	@Test(description = "Verify that addUser method returns true when successful")
	public void successfulAddUserReturnsTrue() throws DuplicateUserException {

		final boolean res = mu.addUser("abc@gmail.com");

		Assert.assertTrue(res);
	}

}
