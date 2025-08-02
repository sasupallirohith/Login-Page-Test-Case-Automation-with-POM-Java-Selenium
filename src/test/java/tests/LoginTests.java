package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalid@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertEquals(errorMsg, "Invalid email or password", "Error message should match expected value");
    }

    @Test
    public void testPasswordMaskedButton() {
        loginPage.enterPassword("somepassword");
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default");
        loginPage.togglePasswordVisibility();
        Assert.assertTrue(loginPage.isPasswordVisible(), "Password should be visible after toggle");
    }

    @Test
    public void testPresenceOfLoginElements() {
        Assert.assertTrue(loginPage.isElementPresent(By.name("email")), "User ID input field should be present");
        Assert.assertTrue(loginPage.isElementPresent(By.name("password")), "Password input field should be present");
        Assert.assertTrue(loginPage.isElementPresent(By.cssSelector("button[aria-label='toggle password visibility']")), "Password toggle should be present");
        Assert.assertTrue(loginPage.isElementPresent(By.xpath("//button[contains(text(), 'Login')]")), "Login button should be present");
    }
}
