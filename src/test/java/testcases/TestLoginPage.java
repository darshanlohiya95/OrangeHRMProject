package testcases;
import browser.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BuzzPage;
import pages.DashboardPage;
import pages.LoginPage;

public class TestLoginPage {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private BuzzPage buzzPage;

    @BeforeMethod
    public void lunchBrowser(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        buzzPage = new BuzzPage();
    }
    @AfterMethod
    public void tearDown(){
        BrowserFactory.quitDriver();
    }

    @Test(groups = "smoke")
    public void test1_postCommentAndPostBtnVerification() {
        loginPage.login("Admin", "admin123");
        dashboardPage.clickOnBuzz();
        buzzPage.enterComment("Good Morning Darshan Lohiya.....");
        Assert.assertTrue(buzzPage.isPostButtonIsVisible());
    }

    @Test
    public void test2_postCommentAndPostBtnVerification() {
        loginPage.login("Admin", "admin123");
        dashboardPage.clickOnBuzz();
        buzzPage.enterComment("Good Night Darshan Lohiya....");
        Assert.assertTrue(buzzPage.isPostButtonIsVisible());
    }
}
