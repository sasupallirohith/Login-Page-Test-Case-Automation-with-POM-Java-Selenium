package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Optional: Use ChromeOptions to handle browser permissions (like notifications)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // prevents browser notification popups
        options.addArguments("--remote-allow-origins=*"); // fixes possible ChromeDriver errors

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dev-dash.janitri.in/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
