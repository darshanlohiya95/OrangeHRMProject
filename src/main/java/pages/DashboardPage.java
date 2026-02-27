package pages;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Constructor
    public  DashboardPage(){
        driver= BrowserFactory.getDriver();
    }

    // Locator
    private By admin_loc = By.xpath("//span[text()='Admin']");
    private By pim_loc = By.xpath("//span[text()='PIM']");
    private By leave_loc = By.xpath("//span[text()='Leave']");
    private By buzz_loc = By.xpath("//span[text()='Buzz']");

    // Actions
    public void clickOnAdmin(){
        driver.findElement(admin_loc).click();
    }
    public void clickOnPIM(){
        driver.findElement(pim_loc).click();
    }
    public void clickOnLeave(){
        driver.findElement(leave_loc).click();
    }
    public void clickOnBuzz(){
        driver.findElement(buzz_loc).click();
    }

    // Business Logic
    public void postText(){

    }
}
