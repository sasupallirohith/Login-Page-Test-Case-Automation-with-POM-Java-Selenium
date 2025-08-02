package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By userIdField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(), 'Login')]");
    private By eyeIcon = By.cssSelector("button[aria-label='toggle password visibility']");
    private By errorMsg = By.cssSelector(".MuiAlert-message"); // optional: customize this based on actual DOM

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUserId(String userId) {
        WebElement emailInput = driver.findElement(userIdField);
        emailInput.clear();
        emailInput.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passInput = driver.findElement(passwordField);
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    // Verifications
    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        return driver.findElement(passwordField).getAttribute("type").equals("password");
    }

    public boolean isPasswordVisible() {
        return driver.findElement(passwordField).getAttribute("type").equals("text");
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getErrorMessage() {
        if (isElementPresent(errorMsg)) {
            return driver.findElement(errorMsg).getText();
        } else {
            return "No error message displayed.";
        }
    }
}
