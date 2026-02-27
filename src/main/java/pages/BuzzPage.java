package pages;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuzzPage {
    WebDriver driver;

    // Constructor
    public  BuzzPage(){
        driver= BrowserFactory.getDriver();
    }

    // Locator
    private By commentBox= By.tagName("textarea");
    private By postBtn= By.xpath("//form//button");

    // Actions
    public void enterComment(String comment){
        driver.findElement(commentBox).sendKeys(comment);
    }

    public boolean isPostButtonIsVisible(){
        return driver.findElement(postBtn).isEnabled();
    }
}