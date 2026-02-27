package pages;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Locator
    private By username_loc = By.name("username");
    private By password_loc = By.name("password");
    private By clickLoginBtn_loc = By.tagName("button");

    // Constructor
    public LoginPage(){
        driver = BrowserFactory.getDriver();
    }

    // Actions
    public void enterUsername(String user){
        driver.findElement(username_loc).sendKeys(user);
    }

    public void enterPassword(String pass){
        driver.findElement(password_loc).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(clickLoginBtn_loc).click();
    }

    // Business Logic
    public void login(String user, String pass){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }
}
