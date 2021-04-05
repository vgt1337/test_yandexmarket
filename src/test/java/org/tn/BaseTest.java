package org.tn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest
{
    protected WebDriver _webDriver;

    @BeforeSuite
    public void DoBeforeAllTheTests()
    {

    }

    @AfterSuite
    public void DoAfterAllTheTests()
    {

    }

    @BeforeMethod
    public void DoBeforeEachTheTests()
    {

        switch (TestSettings.BrowserSelect)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\vgt_\\IdeaProjects\\test_yandexmarket\\chromedriver.exe");
            _webDriver = new ChromeDriver();
                break;
            case "firefox": _webDriver = new FirefoxDriver();
                break;
            case "ie": _webDriver = new InternetExplorerDriver();
                break;
        }
        _webDriver.manage().deleteAllCookies();
        _webDriver.navigate().to(TestSettings.HostPrefix);
        _webDriver.manage().window().fullscreen();
    }

    @AfterMethod
    public void DoAfterEachTheTests()
    {
        _webDriver.quit();
    }

}
