package org.tn;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
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

    @Before
    public void DoBeforeEachTheTests()
    {

        switch (TestSettings.BrowserSelect)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/chromedriver.exe");
            _webDriver = new ChromeDriver();
                break;
            case "firefox": _webDriver = new FirefoxDriver();
                System.setProperty("webdriver.firefox.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/geckodriver.exe");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/chromedriver.exe");
                _webDriver = new ChromeDriver();
                break;
        }
        _webDriver.manage().window().maximize();
        _webDriver.manage().deleteAllCookies();
        _webDriver.get(TestSettings.HostPrefix);
    }

    @After
    public void DoAfterEachTheTests()
    {
        _webDriver.quit();
    }

}
