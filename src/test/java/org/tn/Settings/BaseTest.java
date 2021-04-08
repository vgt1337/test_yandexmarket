package org.tn.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Driver
{

    @BeforeSuite
    public void DoBeforeAllTheTests()
    {

    }

    @AfterSuite
    public void DoAfterAllTheTests()
    {

    }

    @BeforeTest(alwaysRun= true)
    public void DoBeforeEachTheTests()
    {
        InitDriver();
    }

    @AfterTest(alwaysRun= true)
    public void DoAfterEachTheTests()
    {
        CloseDriver();
    }

}
