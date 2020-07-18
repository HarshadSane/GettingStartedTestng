package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import app.DuplicateUserException;
import app.ManageUser;

public class UnitTestWithDP {
	private ManageUser mu;

	@Test(dataProvider = "invalidEmailProvider", expectedExceptions = IllegalArgumentException.class)
	public void emptyUserThrowsException(String invalidEmail) throws DuplicateUserException {
		final boolean res = mu.addUser(invalidEmail);

		Assert.assertTrue(res);
	}

	@DataProvider
	protected Object[][] invalidEmailProvider() {
		return new Object[][] { { "" }, { "abc.com" }, { "abc@gmailcom" } };
	}

	@BeforeMethod
	public void setup() {
		mu = new ManageUser();
	}
}
